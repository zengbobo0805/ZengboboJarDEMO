package builder.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * 模式的使用场景
 * <p>
 * 1.相同的方法，不同的执行顺序，产生不同的事件结果时；
 * 2.多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时；
 * 3.产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候使用建造者模式非常合适。
 * <p>
 * <p>
 * description: 内涵段子默认导航栏
 * <p>
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public class DefaultNavigation<D extends AbsNavigationBar.Builder.NavigationParams> extends
        AbsNavigationBar<DefaultNavigation.Builder.DefaultNavigationParams> {
    public DefaultNavigation(Builder.DefaultNavigationParams params) {
        super(params);
    }

    @Override
    public void applyView() {
        // 给我们的导航条绑定资源
//        setImageResource(R.id.iv_left, getParams().leftIconRes);
//        setImageResource(R.id.iv_right, getParams().rightIconRes);
//        setImageResource(R.id.iv_right_icon, getParams().textRightIconRes);
//        setText(R.id.title_tv, getParams().title);
//        setText(R.id.left_tv, getParams().leftTv);
//        setText(R.id.right_tv, getParams().rightTv);
//        setBackgroundColor(R.id.title_bar, getParams().bgColor);
//        setOnClickListener(R.id.left_ll, getParams().leftOnClickListener);
//        setOnClickListener(R.id.right_ll, getParams().rightOnClickListener);
    }

    @Override
    public int bindLayoutId() {
        // 绑定布局layoutId
//        return R.layout.navigation_default;
        return -1;
    }

    // 构建导航条类
    public static class Builder extends AbsNavigationBar.Builder {
        private DefaultNavigationParams params;

        public Builder(Context context, ViewGroup parent) {
            params = new DefaultNavigationParams(context, parent);
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setRight(String right) {
            params.rightTv = right;
            return this;
        }

        public Builder setLeft(String left) {
            params.leftTv = left;
            return this;
        }

        public Builder setLeftIcon(int iconRes) {
            params.leftIconRes = iconRes;
            return this;
        }

        public Builder setRightIcon(int iconRes) {
            params.rightIconRes = iconRes;
            return this;
        }

        public Builder setTitleBackgroundColor(int bgColor) {
            params.bgColor = bgColor;
            return this;
        }

        public Builder setLeftOnClickListener(View.OnClickListener onClickListener) {
            params.leftOnClickListener = onClickListener;
            return this;
        }

        public Builder setRightOnClickListener(View.OnClickListener onClickListener) {
            params.rightOnClickListener = onClickListener;
            return this;
        }

        @Override
        public DefaultNavigation<NavigationParams> create() {
            DefaultNavigation<NavigationParams> navigation = new DefaultNavigation<NavigationParams>(params);
            return navigation;
        }

        // 默认的配置参数
        public static class DefaultNavigationParams extends NavigationParams {
            //标题
            public String title;
            //左边图片资源
            public int leftIconRes;
            //右边图片资源
            public int rightIconRes;
            //左边的点击事件
            public View.OnClickListener leftOnClickListener;
            //右边的点击事件
            public View.OnClickListener rightOnClickListener;
            public String leftTv;
            public String rightTv;
            public int bgColor;

            public DefaultNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}