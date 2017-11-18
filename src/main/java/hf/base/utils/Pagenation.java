package hf.base.utils;

import com.google.common.collect.Lists;
import hf.base.contants.Constants;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Pagenation<T> {
    private int currentPage;
    private int nextPage;
    private int pageSize;
    private int totalPage;
    private int totalSize;
    private List<T> data;

    public Pagenation(List<T> list) {

    }

    public Pagenation(List<T> list,int currentPage,int pageSize) {
        if(CollectionUtils.isEmpty(list)) {
            this.currentPage = 1;
            this.nextPage = 1;
            this.pageSize = pageSize;
            this.totalPage = 1;
            this.totalSize = 0;
            this.data = new ArrayList<>();
        } else {
            List<List<T>> lists = Lists.partition(list,pageSize);
            this.totalSize = list.size();
            this.pageSize = pageSize;
            this.totalPage = lists.size();
            int actualPage = lists.size();
            this.currentPage = actualPage>currentPage?currentPage:actualPage;
            this.nextPage = this.currentPage+1>actualPage?actualPage:this.currentPage+1;
            this.data = lists.get(this.currentPage-1);
        }
    }
}
