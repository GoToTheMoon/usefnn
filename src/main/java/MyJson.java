import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyJson {
    public static void main(String[] args) throws JSONException {
        String hh="result:[[10, 4, 6, 9, 13, 7, 5, 11, 8, 12, 0, 3, 14, 1, 2], [0]]";
        String hhh=hh.split("result:")[1].substring(2);

        String[] ju=hhh.split(",");
        System.out.println(ju[0]);
        System.out.println(hh.length());
        System.out.println(hh.charAt(2093));

        ParseJson(hh) ;
        CreateJson();
        List j = new ArrayList();
        List kk=new ArrayList();
        j.add("l");
        kk.add(j);
        kk.add(1);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
        System.out.println(dateFormat.format(date));
        System.out.println(kk);
        Map<String,String> J=new HashMap<String, String>();
        J.put("S","1");
        J.put("L","7");
        J.put("p","4");
        Map<Double,String> k = new HashMap<Double,String>();
        k.put(0.368,"0");
        k.put(0.9,"1");
        k.put(0.667887890678900956789087657,"2");
        k.put(0.3453,"3");
        k.put(0.89,"4");
        k.put(0.789544,"5");
        List h=new ArrayList<Double>();
        h.add(0.368);
        h.add(0.9);
        h.add(0.667887890678900956789087657);
        h.add(0.3453);
        h.add(0.89);
        h.add(0.789544);
        List o=new ArrayList<Integer>();
        h.sort(Collections.reverseOrder());
        System.out.println(h);
        for (int i = 0; i<h.size(); i++){
            String u=k.get(h.get(i));
            o.add(i,u);
        }
        System.out.println(o);
    }

    //解析JSON
    private static void ParseJson(String jsonString) throws JSONException
    {
        JSONObject jObject = new JSONObject(jsonString);
        if (jObject.isNull("List")){
            System.out.println("ops");
        }else {
            System.out.println("lll");
        }
        JSONArray a=jObject.getJSONArray("List");
        String h=a.get(0).toString();
        JSONObject jObject1 = new JSONObject(h);
        String ui= jObject1.get("sex").toString();
        System.out.println(jObject1.get("sex"));
        System.out.println(ui);
    }

    //创建一个JSON
    private static void CreateJson() throws JSONException
    {
        // 下面构造两个map、一个list和一个Employee对象
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");

        // 将Map转换为JSONArray数据
        JSONArray jArray = new JSONArray();
        jArray.put(map1);
        jArray.put(map2);
        //定义JSON
        JSONObject jObject=new JSONObject();
        jObject.put("List", jArray);
        jObject.put("Count","1200");

        System.out.println(jObject.toString());
    }
}