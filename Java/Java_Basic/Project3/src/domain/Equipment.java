package domain;

/**
 * @author: zhanghao
 * @date: 2021/9/19-18:42
 */

/**
 * @Description
 */
public abstract class Equipment {
    private String band;
    private String title;

    public Equipment(String band, String title) {
        this.band = band;
        this.title = title;
    }

    public Equipment() {
    }

    @Override
    public String toString() {
        return
                band +
                "(" + title + ')';
    }
}
