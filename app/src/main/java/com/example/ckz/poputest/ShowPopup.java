package com.example.ckz.poputest;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by CKZ on 2017/7/10.
 */

public class ShowPopup {

    private  ShowPopup showPopup;

    private Context context;

    private LayoutInflater inflater;

    private View popView;

    private PopupWindow popupWindow;

    /**
     * 初始化
     * @param context
     */
    public ShowPopup (Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
        showPopup = this;
    }

    /**
     * 输入布局文件，设置popwindow
     * @param layoutId
     * @return
     */
    public ShowPopup showSimplePopupWindows(int layoutId){
        popView = inflater.inflate(layoutId,null);
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        ColorDrawable dw = new ColorDrawable(0x30000000);
        popupWindow.setBackgroundDrawable(dw);
        return showPopup;
    }

    /**
     * 设置弹窗动画
     * @param animId
     * @return showPopu
     */
    public ShowPopup setAnim(int animId){
       if (popupWindow!=null){
           popupWindow.setAnimationStyle(animId);
       }
       return showPopup;
    }

    /**
     * 将弹窗设置在底部
     * @param parent
     * @return
     */
    public ShowPopup atBottom(View parent){
        if (popupWindow!=null){
            popupWindow.showAtLocation(parent, Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
        }
        return showPopup;
    }

    /**
     * 设置悬浮框位置，偏移量
     * @param paren
     * @param x
     * @param y
     * @return
     */
    public ShowPopup dropDown(View paren,int x,int y){
        if (popupWindow!=null){
            popupWindow.showAsDropDown(paren,x,y);
        }
        return showPopup;
    }

    /**
     * 设置弹窗的位置以及偏移量
     * @param parent
     * @param gravity
     * @param x
     * @param y
     * @return
     */
    public ShowPopup atLocation(View parent,int gravity,int x,int y){
        if (popupWindow!=null){
            popupWindow.showAtLocation(parent,gravity,x,y);
        }
        return showPopup;
    }


    /**
     * 设置布局文件中控件的点击事件
     * @param id
     * @param listener
     * @return
     */
   public ShowPopup setClick(int id,View.OnClickListener listener){
       if (popView!=null){
           popView.findViewById(id).setOnClickListener(listener);
       }
       return showPopup;
   }

    /**
     * 关闭弹窗
     * @param id
     * @return
     */
   public ShowPopup setDismissClick(int id){
       if (popupWindow!=null && popView!=null){
           popView.findViewById(id).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   popupWindow.dismiss();
               }
           });
       }
       return showPopup;
   }

    /**
     * 获取view
     * @return
     */
   public View getView(){
       if (popView!=null){
           return popView;
       }
       return null;
   }
}
