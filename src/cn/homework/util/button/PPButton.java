package cn.homework.util.button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cn.homework.util.image.ImageView;

public class PPButton extends ImageView{
		int row; //按扭的横坐标
		int col;  // 按扭的纵坐标
		public void setRow(int row){
			this.row=row;
		}
		public int getRow(){
			return row;
		}
		public void setCol(int col){
			this.col=col;
		}
		public int getCol(){
			return col;
		}
}
