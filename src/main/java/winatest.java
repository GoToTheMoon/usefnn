
import dm.impl.ml.models.*;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


public class winatest {
    public static void main(String[] args) throws Exception {
        HashMap<String,HashMap<String,List>> id=Init("");

        Winamodel_download wm_random= Winamodel_download.getInstance("",id);

        String j="{\"reqid\":\"c5c9749257244b3db9e5ea80d82ae65a\",\"logtime\":1530669600781,\"imei\":\"351702077323828\",\"android_id\":\"781846f80cd91ded\",\"mac\":\"f8:23:b2:af:a0:18\",\"ua\":\"Mozilla/5.0 (Linux; Android 6.0; NEM-AL10 Build/HONORNEM-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36\",\"appid\":\"101010\",\"app_pkg\":null,\"ip\":\"222.218.97.51\",\"callback_ip\":\"222.218.97.51\",\"vendor\":\"NEM\",\"device\":\"AL10\",\"os\":\"Android\",\"os_ver\":\"6.0\",\"sh\":640,\"sw\":100,\"style\":\"flowinfo\",\"brw\":null,\"brw_ver\":null,\"app_ver\":\"1.0\",\"device_type\":1,\"ot\":1,\"ct\":3,\"code_id\":\"nsoJjnF11041\",\"solt_id\":\"5603535\",\"adList\":[{\"ad_id\":\"0\",\"ad_title\":\"神奇的多功能豆腐机\",\"ad_desc\":\"京东\",\"ad_keywords\":\"嘴 馋 吗 ？ 不如 来点 熟食 腊味 ~ 京东\",\"click_url\":\"http://cpro.baidu.com/adx.php\"},{\"ad_id\":\"1\",\"ad_title\":\"关于氧气的问题\",\"ad_desc\":\"关于氧气的问题\",\"ad_keywords\":\"真空 手套 箱 etelux 使用 说明\",\"click_url\":\"http://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"2\",\"ad_title\":\"氧气直播仪\",\"ad_desc\":\"智能煤气 氧气检测仪\",\"ad_keywords\":\"氧气 检测 仪 智能 煤气\",\"click_url\":\"https://cpo.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"3\",\"ad_title\":\"布袋皱纹器\",\"ad_desc\":\"除尘布袋 除尘器布袋\",\"ad_keywords\":\"布袋 除尘器 除尘\",\"click_url\":\"http://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"4\",\"ad_title\":\"视频会议系统方案\",\"ad_desc\":\"视频会议系统建设方案及设备清单\",\"ad_keywords\":\"视频会议 系统 方案 建设 及 设备 清单\",\"click_url\":\"http://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"5\",\"ad_title\":\"金属检测仪\",\"ad_desc\":\"苒小米有品机\",\"ad_keywords\":\"金属 检测 仪 苒 芮 机\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"6\",\"ad_title\":\"好看视频\",\"ad_desc\":\"你喜欢的才好看\",\"ad_keywords\":\"好看 视频 你 喜欢 的 才\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"7\",\"ad_title\":\"好看视频\",\"ad_desc\":\"你喜欢的才好看\",\"ad_keywords\":\"好看 视频 你 喜欢 的 才\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"8\",\"ad_title\":\"企业怎么办理400电话\",\"ad_desc\":\"如何申请400电话\",\"ad_keywords\":\"企业 怎么 办理 400 电话 如何 申请\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"9\",\"ad_title\":\"高中暑假补习班\",\"ad_desc\":\"高中补习班收费标准\",\"ad_keywords\":\"高中 暑假 补习班 收费 标准\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"10\",\"ad_title\":\"到底选哪个好\",\"ad_desc\":\"服务式办公室出租租赁\",\"ad_keywords\":\"办公室 租赁 服务 式 出租\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"11\",\"ad_title\":\"视频会议设备\",\"ad_desc\":\"视频会议需要哪些设备\",\"ad_keywords\":\"视频会议 设备 需要 哪些\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"12\",\"ad_title\":\"高低温冲击试验箱\",\"ad_desc\":\"高低温冲击试验箱有限公司\",\"ad_keywords\":\"高低温 冲击 试验 箱 有限公司\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"13\",\"ad_title\":\"58同城\",\"ad_desc\":\"管道清洗，清理化粪池，抽污水，管道维修。\",\"ad_keywords\":\"58 同城 管道 清洗 ， 清理 化粪池 抽 污水 维修 。\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"14\",\"ad_title\":\"58同城\",\"ad_desc\":\"装修涵盖住宅/办公楼/商场等优惠尽在58同城\",\"ad_keywords\":\"58 同城 装修 涵盖 住宅 / 办公楼 商场 等 优惠 尽 在\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"15\",\"ad_title\":\"腾讯天天快报\",\"ad_desc\":\"赶快下载吧\",\"ad_keywords\":\"腾讯 天天 快报 赶快 下载 吧\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"16\",\"ad_title\":\"腾讯天天快报\",\"ad_desc\":\"下载查看\",\"ad_keywords\":\"腾讯 天天 快报 下载 查看\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"17\",\"ad_title\":\"各大建材品牌尽在58同城！\",\"ad_desc\":\"全城优质的建材都在这！\",\"ad_keywords\":\"各大 建材 品牌 尽 在 58 同城 ！ 全城 优质 的 都 这\",\"click_url\":\"http://m.baidu.com/mobads.php\"},{\"ad_id\":\"18\",\"ad_title\":\"建筑材料，集装箱，钢板房，你需要的58这里都有！\",\"ad_desc\":\"全城优质的建材都在这\",\"ad_keywords\":\"建筑 材料 ， 集装箱 钢板 房 你 需要 的 58 这里 都 有 ！ 全城 优质 建材 在 这\",\"click_url\":\"http://m.baidu.com/mobads.php\"}]}";
        String h="{\"reqid\":\"c746765f8be84801b5c26d4eaf89f803\",\"logtime\":1531470691114,\"imei\":\"99000561232053\",\"android_id\":\"768cd0a0cc1bc536\",\"mac\":\"02:00:00:00:00:00\",\"ua\":\"Mozilla/5.0 (Linux; Android 4.4.4; Coolpad T2-C01 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36\",\"appid\":\"101010\",\"app_pkg\":null,\"ip\":\"180.99.96.200\",\"callback_ip\":\"180.99.96.200\",\"vendor\":\"CoolpadT2-C01\",\"device\":\"Coolpad T2-C01\",\"os\":\"Android\",\"os_ver\":\"4.4.4\",\"sh\":640,\"sw\":100,\"style\":\"flowinfo\",\"brw\":null,\"brw_ver\":null,\"app_ver\":\"1.0\",\"device_type\":1,\"ot\":0,\"ct\":5,\"code_id\":\"nsoJjnF11041\",\"solt_id\":\"5859791\",\"adList\":[{\"ad_id\":\"0\",\"ad_title\":\"六旬老人种植满口牙的价格是多少\",\"ad_desc\":\"种植满口牙\",\"ad_keywords\":\"六旬 老人 种植 满口 牙 的 价格 是 多少\",\"click_url\":\"https://dsp.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"1\",\"ad_title\":\"近视眼的手术费用大概是多少钱\",\"ad_desc\":\"近视手术费\",\"ad_keywords\":\"近视眼 的 手术费 用 大概 是 多少 钱 近视\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"2\",\"ad_title\":\"alc板材价格\",\"ad_desc\":\"供应ALC轻质隔墙板价格\",\"ad_keywords\":\"alc 板材 价格 供应 轻质 隔 墙板\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"3\",\"ad_title\":\"数控开料机价格\",\"ad_desc\":\"数控开料机多少钱一台\",\"ad_keywords\":\"数控 开料 机 价格 多少 钱 一台\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"4\",\"ad_title\":\"空气能热泵报价\",\"ad_desc\":\"空气源热泵价格多少钱\",\"ad_keywords\":\"空气 能 热 泵 报价 源 价格 多少 钱\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"5\",\"ad_title\":\"汉堡加盟品牌\",\"ad_desc\":\"甲醛检测盒\",\"ad_keywords\":\"甲醛 检测 一次 多少 钱 盒\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"6\",\"ad_title\":\"家用新风系统价格\",\"ad_desc\":\"新风系统厂家\",\"ad_keywords\":\"家用 新风 系统 价格 厂家\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"7\",\"ad_title\":\"苏州新楼盘价格\",\"ad_desc\":\"苏州开盘楼盘价格时间\",\"ad_keywords\":\"苏州 新 楼盘 价格 开盘 时间\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"8\",\"ad_title\":\"塑胶破碎机\",\"ad_desc\":\"塑料破碎机可破碎任何塑料\",\"ad_keywords\":\"塑胶 破碎机 塑料 可 破碎 任何\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"},{\"ad_id\":\"9\",\"ad_title\":\"太仓木材加工厂\",\"ad_desc\":\"想知道太仓港木材市场 木方木材加工厂\",\"ad_keywords\":\"太仓 木材 加工厂 想 知道 港 市场 木方\",\"click_url\":\"https://cpro.baidu.com/cpro/ui/uijs.php\"}]}";

        String hj="{\n" +
                "\t\"reqid\": \"db90c161-cf26-41b3-95a0-c3c0aa7d8ff8\",\n" +
                "\t\"logtime\": 1537260580975,\n" +
                "\t\"idfa\": \"5D8BADB6-B7D1-46DE-BDAB-B66468A1EFCC\",\n" +
                "\t\"mac\": \"02:00:00:00:00:00\",\n" +
                "\t\"ua\": \"Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1\",\n" +
                "\t\"appid\": \"test.wina.com\",\n" +
                "\t\"app_pkg\": \"test.wina.com\",\n" +
                "\t\"ip\": \"180.173.92.201\",\n" +
                "\t\"callback_ip\": \"180.173.92.201\",\n" +
                "\t\"vendor\": \"apple\",\n" +
                "\t\"device\": \"iphone 7\",\n" +
                "\t\"os\": \"IOS\",\n" +
                "\t\"os_ver\": \"10\",\n" +
                "\t\"sh\": 1280,\n" +
                "\t\"sw\": 720,\n" +
                "\t\"style\": \"banner\",\n" +
                "\t\"app_ver\": \"1.0.1\",\n" +
                "\t\"device_type\": 1,\n" +
                "\t\"ot\": 1,\n" +
                "\t\"ct\": 100,\n" +
                "\t\"code_id\": \"a10001\",\n" +
                "\t\"solt_id\": \"987654\",\n" +
                "\t\"adList\": [{\n" +
                "\t\t\"ad_id\": \"0\",\n" +
                "\t\t\"ad_title\": \"\\\\xE6\\\\x9C\\\\x89\\\\xE8\\\\xB0\\\\x81\\\\xE7\\\\x9F\\\\xA5\\\\xE9\\\\x81\\\\x93\\\\xE6\\\\xAC\\\\xA2\\\\xE4\\\\xB9\\\\x90\\\\xE6\\\\x96\\\\x97\\\\xE7\\\\x89\\\\x9B\\\\xE9\\\\x87\\\\x8C\\\\xE7\\\\x9A\\\\x84\\\\xE4\\\\xBA\\\\x94\\\\xE8\\\\x8A\\\\xB1\\\\xE7\\\\x89\\\\x9B\\\\xE6\\\\x98\\\\xAF\\\\xE4\\\\xBB\\\\x80\\\\xE4\\\\xB9\\\\x88\",\n" +
                "\t\t\"ad_desc\": \"\\\\xE6\\\\xAC\\\\xA2\\\\xE4\\\\xB9\\\\x90\\\\xE6\\\\x96\\\\x97\\\\xE7\\\\x89\\\\x9B\\\\xE7\\\\x89\\\\x9B\",\n" +
                "\t\t\"ad_type\": \"P\",\n" +
                "\t\t\"ad_keywords\":\"\"\n" +
                "\t}, {\n" +
                "\t\t\"ad_id\": \"1\",\n" +
                "\t\t\"ad_title\": \"\\\\xE9\\\\x99\\\\x8D\\\\xE8\\\\xA1\\\\x80\\\\xE7\\\\xB3\\\\x96\\\\xE6\\\\x9C\\\\x89\\\\xE5\\\\x93\\\\xAA\\\\xE4\\\\xBA\\\\x9B\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95+\\\\xE9\\\\x99\\\\x8D\\\\xE8\\\\xA1\\\\x80\\\\xE7\\\\xB3\\\\x96\\\\xE7\\\\x9A\\\\x84\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95\\\\xE5\\\\x93\\\\xAA\\\\xE4\\\\xBA\\\\x9B\\\\xE5\\\\xA5\\\\xBD\",\n" +
                "\t\t\"ad_desc\": \"\\\\xE9\\\\x99\\\\x8D\\\\xE7\\\\xB3\\\\x96\\\\xE7\\\\x9A\\\\x84\\\\xE5\\\\xA5\\\\xBD\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95\",\n" +
                "\t\t\"ad_type\": \"D\",\n" +
                "\t\t\"ad_keywords\":\"\"\n" +
                "\t}, {\n" +
                "\t\t\"ad_id\": \"2\",\n" +
                "\t\t\"ad_title\": \"\\\\xE5\\\\xA4\\\\xA7\\\\xE5\\\\x8F\\\\xA3\\\\xE5\\\\xBE\\\\x84\\\\xE8\\\\x9E\\\\xBA\\\\xE6\\\\x97\\\\x8B\\\\xE9\\\\x92\\\\xA2\\\\xE7\\\\xAE\\\\xA1\\\\xE9\\\\x80\\\\x82\\\\xE7\\\\x94\\\\xA8\\\\xE8\\\\x8C\\\\x83\\\\xE5\\\\x9B\\\\xB4\\\\xE7\\\\xAE\\\\x80\\\\xE4\\\\xBB\\\\x8B\",\n" +
                "\t\t\"ad_desc\": \"\\\\xE6\\\\x97\\\\xA0\\\\xE7\\\\xBC\\\\x9D\\\\xE9\\\\x92\\\\xA2\\\\xE7\\\\xAE\\\\xA1\",\n" +
                "\t\t\"ad_type\": \"P\",\n" +
                "\t\t\"ad_keywords\":\"\"\n" +
                "\t}, {\n" +
                "\t\t\"ad_id\": \"3\",\n" +
                "\t\t\"ad_title\": \"\\\\xE8\\\\x85\\\\xBA\\\\xE7\\\\x82\\\\x8E\\\\xE5\\\\xB0\\\\x8F\\\\xE7\\\\xB1\\\\xB32\",\n" +
                "\t\t\"ad_desc\": \"\",\n" +
                "\t\t\"ad_type\": \"D\",\n" +
                "\t\t\"ad_keywords\":\"\"\n" +
                "\t}, {\n" +
                "\t\t\"ad_id\": \"4\",\n" +
                "\t\t\"ad_title\": \"\\\\xE9\\\\x99\\\\x8D\\\\xE8\\\\xA1\\\\x80\\\\xE7\\\\xB3\\\\x96\\\\xE6\\\\x9C\\\\x89\\\\xE5\\\\x93\\\\xAA\\\\xE4\\\\xBA\\\\x9B\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95+\\\\xE9\\\\x99\\\\x8D\\\\xE8\\\\xA1\\\\x80\\\\xE7\\\\xB3\\\\x96\\\\xE7\\\\x9A\\\\x84\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95\\\\xE5\\\\x93\\\\xAA\\\\xE4\\\\xBA\\\\x9B\\\\xE5\\\\xA5\\\\xBD\",\n" +
                "\t\t\"ad_desc\": \"\\\\xE9\\\\x99\\\\x8D\\\\xE7\\\\xB3\\\\x96\\\\xE7\\\\x9A\\\\x84\\\\xE5\\\\xA5\\\\xBD\\\\xE6\\\\x96\\\\xB9\\\\xE6\\\\xB3\\\\x95\",\n" +
                "\t\t\"ad_type\": null,\n" +
                "\t\t\"ad_keywords\":\"\"\n" +
                "\t}]\n" +
                "}";
        JSONObject jo=new JSONObject(hj);
        for(int i=0;i<10;i++){

            String result_random=wm_random.predictAll(jo);

            System.out.printf("random result:%s \n",result_random);
        }
    }

    public static String[] onArrayTogaterstr(String[] aa, String[] bb) {

        if (aa == null) {
            return bb;
        }
        String[] collectionStr = new String[aa.length + bb.length];
        System.arraycopy(aa, 0, collectionStr, 0, aa.length);
        System.arraycopy(bb, 0, collectionStr, aa.length, aa.length + bb.length - aa.length);
        return collectionStr;
    }

    protected static ArrayList<HashMap<String,List>> Init8(String mode) throws IOException {
        String path;
        if (mode.equals("test")){
            path="http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + "/user/yukun.huang/winaReqWordsAll_test.csv"+ "?op=open&user.name=dsp";
        } else{
            path="http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + "/user/dm/winafeed/winaReqWordsAll.csv"+ "?op=open&user.name=dsp";
        }

        URL url = new URL(path);

        //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
        InputStreamReader inputStream = new InputStreamReader(url.openStream(),"utf-8");
        BufferedReader br = new BufferedReader(inputStream);
        String value= br.readLine();
        HashMap<String,List> imeikey=new HashMap<>();
        HashMap<String,List> androidkey=new HashMap<>();
        while (null != (value= br.readLine())) {
            String[] values=value.split(",");

            String[] keywords=onArrayTogaterstr(values[3].split(" "),values[4].split(" "));
            Set tSet = new HashSet(Arrays.asList(keywords));
            List keyword=new ArrayList(tSet);

            String imei=values[1];
            String android_id=values[2];

            imeikey.put(imei,keyword);
            androidkey.put(android_id,keyword);
        }
        ArrayList<HashMap<String,List>> K=new ArrayList();
        K.add(0,imeikey);
        K.add(1,androidkey);
        return K;
    }

    public static HashMap<String,HashMap<String,List>> Init(String mode) throws IOException {
        String path;
        if (mode.equals("test")){
            path="http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + "/user/yukun.huang/winaReqWordsAll_test.csv"+ "?op=open&user.name=dsp";
        } else{
            path="http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + "/user/dm/winafeed/winaReqWordsAll.csv"+ "?op=open&user.name=dsp";
        }

        URL url = new URL(path);

        //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
        InputStreamReader inputStream = new InputStreamReader(url.openStream(),"utf-8");
        BufferedReader br = new BufferedReader(inputStream);
        String value= br.readLine();
        HashMap<String,List> imeikey=new HashMap<>();
        HashMap<String,List> androidkey=new HashMap<>();
        while (null != (value= br.readLine())) {
            String[] values=value.split(",");

            String[] keywords=onArrayTogaterstr(values[3].split(" "),values[4].split(" "));
            Set tSet = new HashSet(Arrays.asList(keywords));
            List keyword=new ArrayList(tSet);

            String imei=values[1];
            String android_id=values[2];

            imeikey.put(imei,keyword);
            androidkey.put(android_id,keyword);
        }
        br.close();
        HashMap<String,HashMap<String,List>> K=new HashMap<>();
        K.put("imeikeyword",imeikey);
        K.put("androidkeyword",androidkey);
        return K;
    }

    public static HashMap<String,String[]> get_id() throws IOException {
        String path="http://l-httpfs.prod.qd1.corp.agrant.cn:14000/webhdfs/v1" + "/user/dm/huangyukun/gdt/ctr/imei_act.txt/part-00000"+ "?op=open&user.name=dsp";

        URL url = new URL(path);

        //ByteArrayEntity byteArrayEntity = new ByteArrayEntity(dmpRequestBuilder.build().toByteArray());
        InputStreamReader inputStream = new InputStreamReader(url.openStream(),"utf-8");
        BufferedReader br = new BufferedReader(inputStream);
        String value= br.readLine();

        HashMap<String,String[]> id_ad=new HashMap<>();
        while (null != (value= br.readLine())) {
            String[] values = value.split(":");

            String adc=values[0];
            String[] adkeys=values[1].split(",");

            id_ad.put(adc,adkeys);
        }
        br.close();
        return id_ad;
    }
}