package hf.base.utils;

import com.google.common.collect.Lists;
import hf.base.contants.Constants;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pagenation<T> {
    private int currentPage;
    private int nextPage;
    private int pageSize;
    private int totalPage;
    private int totalSize;
    private List<T> data;
    private ShowPage showPage;
    private Page headPage;
    private Page tailPage;

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
        buildShowPage();
    }

    public Pagenation(List<T> list,int totalSize, int currentPage,int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize +1;
        if(this.totalPage == 0) {
            this.totalPage = 1;
        }
        this.nextPage = currentPage >= totalPage?totalPage:currentPage+1;
        this.totalSize = totalSize;
        this.data = list;

        buildShowPage();
    }

    private void buildShowPage() {
        List<Page> totalPages = new ArrayList<>();
        for(int i=0;i<totalPage;i++) {
            totalPages.add(new Page(i+1,this.currentPage==i+1));
        }
        List<List<Page>> lists = Lists.partition(totalPages,10);
        if(CollectionUtils.isEmpty(lists)) {
            ShowPage showPage = new ShowPage();
            showPage.setPages(Collections.EMPTY_LIST);
            showPage.setShowTail(false);
            showPage.setShowHead(false);
            this.showPage = showPage;
            return;
        }

        int currentShowPageIndex = this.currentPage%10==0?this.currentPage/10:this.currentPage/10+1;

        ShowPage showPage = new ShowPage();
        showPage.setPages(lists.get(currentShowPageIndex-1));
        showPage.setShowHead(currentShowPageIndex!=0);
        showPage.setShowTail(currentShowPageIndex!=this.totalPage-1);

        this.showPage = showPage;
        this.headPage = new Page(1,"首页",false);
        this.tailPage = new Page(totalPage,"最后一页",false);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public ShowPage getShowPage() {
        return showPage;
    }

    public void setShowPage(ShowPage showPage) {
        this.showPage = showPage;
    }

    public Page getHeadPage() {
        return headPage;
    }

    public void setHeadPage(Page headPage) {
        this.headPage = headPage;
    }

    public Page getTailPage() {
        return tailPage;
    }

    public void setTailPage(Page tailPage) {
        this.tailPage = tailPage;
    }

    class ShowPage {
        private List<Page> pages;
        private boolean showHead;
        private boolean showTail;

        public List<Page> getPages() {
            return pages;
        }

        public void setPages(List<Page> pages) {
            this.pages = pages;
        }

        public boolean isShowHead() {
            return showHead;
        }

        public void setShowHead(boolean showHead) {
            this.showHead = showHead;
        }

        public boolean isShowTail() {
            return showTail;
        }

        public void setShowTail(boolean showTail) {
            this.showTail = showTail;
        }
    }

    class Page {
        private Integer pageIndex;
        private String label;
        private boolean selected;

        public Page(Integer pageIndex,boolean selected) {
            this.pageIndex = pageIndex;
            this.label = String.valueOf(pageIndex);
            this.selected = selected;
        }

        public Page(Integer pageIndex,String label,boolean selected) {
            this.pageIndex = pageIndex;
            this.label = label;
            this.selected = selected;
        }

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
