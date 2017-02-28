package builder.navigation;

/**
 * description：定义导航条规范
 * <p>
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public interface INavigation {

    // 绑定布局ID
    public int bindLayoutId();

    // 给View设置参数
    public void applyView();
}