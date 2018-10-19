import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import dm.impl.deeplearning.models.*;
import dm.impl.deeplearning.models.FactorizationMachines;
import dm.utils.AUC;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.log;
import static java.lang.Math.scalb;

public class winauseFNN {
    public static void main(String[] args) throws Exception {
        int f=4;
        String mode=args[0];
        if (mode.matches("FmModel")){
            WinaFNN.fmtrain(f,args[1]);
        }
        if (mode.matches("updateFmModel")){
            WinaFNN.updatefm(args[1]);
        }
        if (mode.matches("bpDeepTrain")){
            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            Random r=new Random();
            URL url = new URL(path);
            WinaFNN fnn=new WinaFNN();
            fnn.fm= FactorizationMachines.getInstance("winafnn/fm.model");
            fnn.bp=new BpDeep(new int[]{22*f,20,1}, 0.05, 0.05);
            fnn.mlp=new MLP(22*f,20,5,2,0.01,"tanh",r);
            fnn.dnp=new Dropout(fnn.data_columns.length*f,new int[]{10},2,r,"tanh",0.01,false,0.2);
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value ;
            while (null != (value= br.readLine())) {
                fnn.fit(value);
            }
            fnn.dnp.savemodel("winafnn/bp.model");
        }
        if (mode.matches("updateBP")){
            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            URL url = new URL(path);
            WinaFNN fnn= WinaFNN.getInstance("winafnn");
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value;
            while (null != (value= br.readLine())) {
                fnn.fit(value);
            }
            fnn.dnp.savemodel("winafnn/bp.model");
        }
        if (mode.matches("FNNpredict")){
            WinaFNN fnn= WinaFNN.getInstance("winafnn");

            String path = "http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + args[1] + "?op=open&user.name=dsp";
            URL url = new URL(path);
            //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String value ;
            File file=new File("yingnapredict.csv");
            Writer csvwriter=new FileWriter(file);
            CSVWriter cwriter=new CSVWriter(csvwriter);
            int nn=0;
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day));
            while((value=br.readLine())!=null) {
                String[] valuess=value.split("<###>");
                nn += 1;
                String[] values= WinaFNN.get_ip(valuess,3);
                String label = values[values.length - 1];
                String[] fea= Arrays.copyOfRange(values,0,values.length-1);
                double p = fnn.predict(fea);
                String[] RET={label,Double.toString(p)};
                cwriter.writeNext(RET);
            }
            Date day1= new Date();
            System.out.println(df.format(day1));
            csvwriter.close();
            System.out.println(nn);
        }
        if (mode.matches("ynpredict")){
            WinaFNN fnn= WinaFNN.getInstance("winafnn");
            String jsonstr="{\n" +
                    "\t\"reqid\": \" e09deb5dbfbc4ea38408c75e38597e44\",\n" +
                    "\t\"logtime\": 1525772971232,\n" +
                    "\t\"imei\": \"865836038713732\",\n" +
                    "\t\"android_id\": \" 2b8e97fd2d285dd0\",\n" +
                    "\t\"mac\": \" 02:00:00:00:00:00\",\n" +
                    "\t\"ua\": \" Mozilla/5.0 (Linux; Android 6.0.1; OPPO R9sk Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36\",\n" +
                    "\t\"appid\": \"10\",\n" +
                    "\t\"app_pkg\": \" com.pdragon.HD1010\",\n" +
                    "\t\"ip\": \"117.152.32.205\",\n" +
                    "\t\"app_ver\":\"1\",\n" +
                    "\t\"device_type\":\"0\",\n" +
                    "\t\"ot\":\"1\",\n" +
                    "\t\"ct\":\"0\",\n" +
                    "\t\"callback_ip\": \" 123.178.83.245\",\n" +
                    "\t\"vendor\": \"OPPO\",\n" +
                    "\t\"device\": \"Oppo\tR9sk\",\n" +
                    "\t\"os\": \"Android\",\n" +
                    "\t\"os_ver\": \"6.0\",\n" +
                    "\t\"sh\": 1920,\n" +
                    "\t\"sw\": 1080,\n" +
                    "\t\"style\": \"banner\",\n" +
                    "\t\"brw\": \" Chrome-Mobile-WebView\",\n" +
                    "\t\"brw_ver\": \"55.0\",\n" +
                    "\t\"adList\": [{\n" +
                    "\t\t\"ad_id\": \"0\",\n" +
                    "\t\t\"ad_title\": \"在每天可以签到赚钱多的网站推荐\",\n" +
                    "\t\t\"ad_desc\": \"签到赚钱\",\n" +
                    "\t\t\"ad_keywords\":\"趣 头条 新\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"1\",\n" +
                    "\t\t\"ad_desc\": \"时候的人回患\",\n" +
                    "\t\t\"ad_title\": \"样治\",\n" +
                    "\t\t\"ad_keywords\":\"hello world\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"2\",\n" +
                    "\t\t\"ad_title\": \"住人集装箱\",\n" +
                    "\t\t\"ad_desc\": \"住人集装箱多少钱一个\",\n" +
                    "\t\t\"ad_keywords\":\"腺 炎 小米 test\"\n" +
                    "\t}]\n" +
                    "}";
            String js="{\n" +
                    "\t\"reqid\": \" e09deb5dbfbc4ea38408c75e38597e44\",\n" +
                    "\t\"logtime\": 1525772971232,\n" +
                    "\t\"imei\": \" 864297035642179\",\n" +
                    "\t\"android_id\": \"00239ae9c47f5f20\",\n" +
                    "\t\"mac\": \" 02:00:00:00:00:00\",\n" +
                    "\t\"ua\": \" Mozilla/5.0 (Linux; Android 6.0.1; OPPO R9sk Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36\",\n" +
                    "\t\"appid\": \"10\",\n" +
                    "\t\"app_pkg\": \"com.songheng.eastnews\",\n" +
                    "\t\"ip\": \"117.152.32.205\",\n" +
                    "\t\"app_ver\":\"1\",\n" +
                    "\t\"device_type\":\"0\",\n" +
                    "\t\"ot\":\"1\",\n" +
                    "\t\"ct\":\"0\",\n" +
                    "\t\"callback_ip\": \" 123.178.83.245\",\n" +
                    "\t\"vendor\": \"OPPO\",\n" +
                    "\t\"device\": \"Oppo\tR9sk\",\n" +
                    "\t\"os\": \"Android\",\n" +
                    "\t\"os_ver\": \"6.0\",\n" +
                    "\t\"sh\": 1920,\n" +
                    "\t\"sw\": 1080,\n" +
                    "\t\"style\": \"banner\",\n" +
                    "\t\"brw\": \" Chrome-Mobile-WebView\",\n" +
                    "\t\"brw_ver\": \"55.0\",\n" +
                    "\t\"adList\": [\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"0\",\n" +
                    "\t\t\"ad_desc\": \"最有福气的三大生肖，一生享福无穷，注定成为大老板 \",\n" +
                    "\t\t\"ad_title\": \"最有福气的三大生肖，一生享福无穷，注定成为大老板！\",\n" +
                    "\t\t\"ad_keywords\":\"二手房 jahf\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"1\",\n" +
                    "\t\t\"ad_title\": \"现在每天可以签到赚钱多的网站推荐\",\n" +
                    "\t\t\"ad_desc\": \"签到赚钱\",\n" +
                    "\t\t\"ad_keywords\":\"趣 头条 新\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"2\",\n" +
                    "\t\t\"ad_title\": \"可以赚钱的捕鱼\",\n" +
                    "\t\t\"ad_desc\": \"捕鱼来了怎么赚钱新手赚钱秘籍\",\n" +
                    "\t\t\"ad_keywords\":\"腺 炎 小米 test\"\n" +
                    "\t}]\n" +
                    "}";
            String js1="{\n" +
                    "\t\"reqid\": \" e09deb5dbfbc4ea38408c75e38597e44\",\n" +
                    "\t\"logtime\": 1525772971232,\n" +
                    "\t\"imei\": \" 864297035642179\",\n" +
                    "\t\"android_id\": \"00239ae9c47f5f20\",\n" +
                    "\t\"mac\": \" 02:00:00:00:00:00\",\n" +
                    "\t\"ua\": \" Mozilla/5.0 (Linux; Android 6.0.1; OPPO R9sk Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36\",\n" +
                    "\t\"appid\": \"10\",\n" +
                    "\t\"app_pkg\": \"com.oppo.cameracom.android.ctsxinwen\",\n" +
                    "\t\"ip\": \"117.152.32.205\",\n" +
                    "\t\"app_ver\":\"1\",\n" +
                    "\t\"device_type\":\"0\",\n" +
                    "\t\"ot\":\"1\",\n" +
                    "\t\"ct\":\"0\",\n" +
                    "\t\"callback_ip\": \" 123.178.83.245\",\n" +
                    "\t\"vendor\": \"OPPO\",\n" +
                    "\t\"device\": \"Oppo\tR9sk\",\n" +
                    "\t\"os\": \"Android\",\n" +
                    "\t\"os_ver\": \"6.0\",\n" +
                    "\t\"sh\": 1920,\n" +
                    "\t\"sw\": 1080,\n" +
                    "\t\"style\": \"banner\",\n" +
                    "\t\"brw\": \" Chrome-Mobile-WebView\",\n" +
                    "\t\"brw_ver\": \"55.0\",\n" +
                    "\t\"adList\": [\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"0\",\n" +
                    "\t\t\"ad_desc\": \"最有福气的三大生肖，一生享福无穷，注定成为大老板 \",\n" +
                    "\t\t\"ad_title\": \"最有福气的三大生肖，一生享福无穷，注定成为大老板！\",\n" +
                    "\t\t\"ad_keywords\":\"二手房 jahf\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"1\",\n" +
                    "\t\t\"ad_title\": \"现在每天可以签到赚钱多的网站推荐\",\n" +
                    "\t\t\"ad_desc\": \"签到赚钱\",\n" +
                    "\t\t\"ad_keywords\":\"趣 头条 新\"\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"ad_id\": \"2\",\n" +
                    "\t\t\"ad_title\": \"可以赚钱的捕鱼\",\n" +
                    "\t\t\"ad_desc\": \"捕鱼来了怎么赚钱新手赚钱秘籍\",\n" +
                    "\t\t\"ad_keywords\":\"腺 炎 小米 test\"\n" +
                    "\t}]\n" +
                    "}";
            int i=0;
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day));

            Date day1= new Date();
            System.out.println(df.format(day1));

            JSONObject jo=new JSONObject(js1);
            String adl=fnn.predictAll(jo);
            String adl1=fnn.predictAll(jo);
            System.out.println(adl);
            System.out.println(adl1);
        }
        if (mode.matches("evalue")){
            File file=new File("yingnapredict.csv");
            CSVReader reader=new CSVReader(new FileReader(file));
            double tp = 0;
            double fn = 0;
            double tn = 0;
            double fp = 0;
            int positive=0;
            int negative=0;

            List<Double> truths = new ArrayList<Double>();
            List<Double> predictions = new ArrayList<Double>();

            double threshold=0.05;
            try {
                String[] values;
                double pall=0;
                int n=0;
                double logloss=0;
                while ((values = reader.readNext()) != null) {
                    double y = Double.parseDouble(values[0]);
                    double p = Double.parseDouble(values[1]);
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
                System.out.format("AUC:%f ",AUC.measure( y,p,1));
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
