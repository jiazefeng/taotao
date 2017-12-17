/**  
 */
package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

/**
 * @Title: TestFastDFS.java
 * @Description: 图片上传测试类
 * @author: Jiazefeng
 * @date: 2017年11月23日 下午3:36:23
 * @version V1.0
 */
public class TestFastDFS {
	@Test
	public void uploadFile() throws Exception {
		// 1、向工程中添加JAR包
		// 2、创建一个配置文件。配置tracker服务器地址
		// 3、加载配置文件
		ClientGlobal.init("D:/project/workspace1/taotao-manager-web/src/main/resources/resource/client.conf");
		// 4、创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 5、使用TrackerClient对象获得TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 6、创建一个StorageServer的引用null就可以
		StorageServer storageServer = null;
		// 7、穿件一个StorageClient对象。TrackerServer、StorageServer两个参数
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 8、使用StorageClient对象上传文件
		String[] strings = storageClient.upload_file("C:/Users/Jiazefeng/Pictures/timg.gif", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void testFastDFSClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient(
				"D:/project/workspace1/taotao-manager-web/src/main/resources/resource/client.conf");
		String string = fastDFSClient.uploadFile("C:/Users/Jiazefeng/Pictures/logo.png");
		System.out.println(string);
	}
}
