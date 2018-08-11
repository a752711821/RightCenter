package com.example.myapplication.entity;

import java.io.Serializable;
import java.util.List;

public class PecialActivitiesEntity {


    /**
     * totalpage : 1
     * error_des : OK
     * activitys : [{"target":"160","type":"1","value":"15272146333798","act_title":"日租卡添加亲情号","act_name":"日租卡添加亲情号","start_time":"20180525000000","end_time":"20181231235959","act_pic":"http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180525/91f908805d03c717f47db51954ed8d61a0d3b5d9.png","act_banner":"http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180525/bb52acdf238b3ff0e27972b8cf661ac2c02d8455.png"},{"target":"160","type":"1","value":"15266339947494","act_title":"定向流量0元购","act_name":"定向流量0元购","start_time":"20180518000000","end_time":"20181231235959","act_pic":"http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180518/8a09b5c25484a9f77a838826d518d380d9310d85.jpg","act_banner":"http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180518/48dc2fae46e6d7f5b73aa0b41c2ce07ac14b51fb.jpg"}]
     * error_code : 00000
     * page : 1
     */

    private String totalpage;
    private String error_des;
    private String error_code;
    private String page;
    private List<ActivitysBean> activitys;

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public String getError_des() {
        return error_des;
    }

    public void setError_des(String error_des) {
        this.error_des = error_des;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<ActivitysBean> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<ActivitysBean> activitys) {
        this.activitys = activitys;
    }

    public static class ActivitysBean implements Serializable {
        /**
         * target : 160
         * type : 1
         * value : 15272146333798
         * act_title : 日租卡添加亲情号
         * act_name : 日租卡添加亲情号
         * start_time : 20180525000000
         * end_time : 20181231235959
         * act_pic : http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180525/91f908805d03c717f47db51954ed8d61a0d3b5d9.png
         * act_banner : http://cache.i-liaoning.com.cn/export/sd/pic/operatepic/act/20180525/bb52acdf238b3ff0e27972b8cf661ac2c02d8455.png
         */

        private String target;
        private String type;
        private String value;
        private String act_title;
        private String act_name;
        private String start_time;
        private String end_time;
        private String act_pic;
        private String act_banner;

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getAct_title() {
            return act_title;
        }

        public void setAct_title(String act_title) {
            this.act_title = act_title;
        }

        public String getAct_name() {
            return act_name;
        }

        public void setAct_name(String act_name) {
            this.act_name = act_name;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getAct_pic() {
            return act_pic;
        }

        public void setAct_pic(String act_pic) {
            this.act_pic = act_pic;
        }

        public String getAct_banner() {
            return act_banner;
        }

        public void setAct_banner(String act_banner) {
            this.act_banner = act_banner;
        }
    }
}
