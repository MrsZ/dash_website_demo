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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.BaseService;
import bean.Video;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ������,����
 * ɾ����Ƶ��Action
 */
public class VideoDelete extends ActionSupport {
	private int videoid;
	private BaseService baseService;
	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public String execute(){
		try{
			Video video=(Video) baseService.ReadByID("Video", videoid);
			//���·��
			String thumbnailPath=video.getThumbnailurl();
			String path=video.getUrl();
			String oripath=video.getOriurl();
			//��ȡ��·��������·����
			String thumbnailrealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+thumbnailPath;
			String realpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+path;
			String orirealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+oripath;
			//DASH Support 
			String segmentrealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+video.getMpdurl().substring(0, video.getMpdurl().lastIndexOf("/"));
			File thumbnailfile=new File(thumbnailrealpath);
			File videofile=new File(realpath);
			File orivideofile=new File(orirealpath);
			//ɾ����֮��صĽ�ͼ�ļ�����Ƶ�ļ�
			if(thumbnailfile!=null){
				thumbnailfile.delete();
			}
			if(videofile!=null){
				videofile.delete();
			}
			if(orivideofile!=null){
				orivideofile.delete();
			}
			//DASH Support
			String segmentdelcommand="cmd /c rmdir /s/q "+"\""+segmentrealpath+"\" ";
			System.out.println(segmentdelcommand);
			Process process=Runtime.getRuntime().exec(segmentdelcommand);
			//------------------------
			BufferedInputStream in = new BufferedInputStream(process.getInputStream());  
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
			String lineStr;  
			while ((lineStr = inBr.readLine()) != null)  
					System.out.println(lineStr);
			if (process.waitFor() != 0) {  
				if (process.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
					System.err.println("Failed!");  
			}  
			inBr.close();  
			in.close();
			//����ɾ���ü�¼
			baseService.delete(video);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
