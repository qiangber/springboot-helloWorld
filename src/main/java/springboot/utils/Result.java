package springboot.utils;

import java.util.HashMap;

/**
 * Created by qiangber on 18-4-16.
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error(String msg) {
        Result r = new Result();
        r.put("code", 500);
        r.put("msg", msg);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

}
