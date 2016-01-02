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

import com.opensymphony.xwork2.ActionSupport;

import service.BaseService;

import bean.Video;
/**
 * @author ������
 * ��ȡ������Ƶ��Ϣ��Action
 */
public class VideoReadAll extends ActionSupport{
	private List<Video> resultvideo;
	private BaseService baseService;
	private int islive;
	
	public List<Video> getResultvideo() {
		return resultvideo;
	}

	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}


	public int getIslive() {
		return islive;
	}

	public void setIslive(int islive) {
		this.islive = islive;
	}

	@SuppressWarnings("unchecked")
	public String execute(){
		try{
			if(islive==0){
				resultvideo=baseService.ReadByProperty("Video","islive",0);
			}else{
				resultvideo=baseService.ReadByProperty("Video","islive",1);
			}
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
