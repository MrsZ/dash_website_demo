/**
 * DASH Website Demo
 * a Website Demo supporting DASH media content upload, generate and watch.һ��֧��DASH�����ϴ������ɡ��ۿ�����վʾ����
 * dont support live DASH currently
 * 
 * Dependencies:
 * DASHEncoder2 (https://github.com/zhanghuicuc/DASHEncoder2) and FFmpeg 
 *
 * ����
 * Hui Zhang
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China/Digital Video Technology
 * 
 * zhanghuicuc@gmail.com
 * http://blog.csdn.net/nonmarking
 * 
 * this website is based on Lei Xiaohua's simplest video website
 */
package action.video;

import java.util.List;

import service.BaseService;

import bean.Video;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ������
 * ����ָ��˳���ȡ��Ƶ��ϢAction
 */
public class VideoReadLimitedByOrder extends ActionSupport {
	private int num;
	private BaseService baseService;
	private List<Video> resultvideo;

	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Video> getResultvideo() {
		return resultvideo;
	}
	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}
	public String execute(){
		try{
			resultvideo= baseService.ReadLimitedByOrder("Video", "edittime", num, "asc");
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
