import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import dm.impl.deeplearning.models.*;
import dm.utils.AUC;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.log;

public class useFNN {
    public static void main(String[] args) throws Exception {
        int f=4;
        String mode=args[0];
        if (mode.matches("FmModel")){
            GDTfnn.fmtrain(f,args[1]);
        }
        if (mode.matches("updateFmModel")){
            GDTfnn.updatefm(args[1]);
        }
        if (mode.matches("bpDeepTrain")){
            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            Random r=new Random();
            URL url = new URL(path);
            GDTfnn fnn=new GDTfnn();
            fnn.fm= FactorizationMachines.getInstance("gdtfnn/fm.model");

            fnn.dnp=new Dropout(22*f,new int[]{15},2,r,"tanh",0.01,false,0.2);
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value = br.readLine();
            while (null != (value= br.readLine())) {
                fnn.fit(value);
            }
            fnn.dnp.savemodel("gdtfnn/bp.model");
        }
        if (mode.matches("updateBP")){
            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            URL url = new URL(path);
            GDTfnn fnn= GDTfnn.getInstance("fnn");
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value = br.readLine();
            while (null != (value= br.readLine())) {
                fnn.fit(value);
            }
            fnn.dnp.savemodel("gdtfnn/bp.model");
        }
        if (mode.matches("FNNpredict")){
            GDTfnn fnn= GDTfnn.getInstance("gdtfnn");

            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            URL url = new URL(path);
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value = br.readLine();
            File file=new File("fnnpredict.csv");
            Writer csvwriter=new FileWriter(file);
            CSVWriter cwriter=new CSVWriter(csvwriter);
            int nn=0;
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day));
            while((value=br.readLine())!=null) {
                String[] values=value.split("\\|\\|");
                nn += 1;
                String label = values[values.length - 1];
                String[] fea= Arrays.copyOfRange(GDTfnn.get_feature(values),0,GDTfnn.get_feature(values).length-1);

                double p = fnn.predict(fea);
                String[] RET={label,Double.toString(p)};
                cwriter.writeNext(RET);
            }
            Date day1= new Date();
            System.out.println(df.format(day1));
            csvwriter.close();
            System.out.println(nn);
        }
        if (mode.matches("evalue")){
            File file=new File("fnnpredict.csv");
            CSVReader reader=new CSVReader(new FileReader(file));
            double tp = 0;
            double fn = 0;
            double tn = 0;
            double fp = 0;
            int positive=0;
            int negative=0;

            List<Double> truths =new ArrayList<Double>();
            List<Double> predictions = new ArrayList<Double>();

            double threshold=0.05;
            try {
                String[] values;
                double pall=0;
                int n=0;
                double logloss=0;
                while ((values = reader.readNext()) != null) {
                    double y = Double.parseDouble(values[values.length-2]);
                    double p = Double.parseDouble(values[values.length-1]);
                    n+=1;
                    pall+=p;
                    logloss+=(1-y)*log(1-p)+y*log(p);
                    truths.add(y);
                    predictions.add(p);

                    if ((y > 0.5) && (p > threshold)) {
                        tp += 1;
                        positive+=1;
                    } else if ((y > 0.5) && (p <= threshold)) {
                        fn += 1;
                        positive+=1;
                    } else if (((y < 0.5) && (p <= threshold))) {
                        tn += 1;
                        negative+=1;
                    } else {
                        fp += 1;
                        negative+=1;
                    }
                }

                double[] y = new double[truths.size()];
                double[] p = new double[predictions.size()];

                for(int i=0;i<truths.size();i++)
                {
                    y[i] = truths.get(i);
                    p[i] = predictions.get(i);
                }

                System.out.format("CTR:%f ",positive*1.0/(positive+negative));
                System.out.format("AUC:%f ", AUC.measure( y,p,1));
                System.out.format("Recall:%f ", tp / (tp + fn));
                System.out.format("Precision:%f ", tp / (tp + fp));
                System.out.format("Accuracy:%f ", (tp + tn) / (tp + fn + tn + fp));
                System.out.format("Positive/Total:%f ", (tp + fp) / (tp + fn + tn + fp));
                System.out.format("pctr_bias %f ",pall/n);
                System.out.format("logloss %f ",-logloss/n);
                System.out.println();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }
    }
