package org.lanqiao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.FaceRecognize;



public class AddPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//真正上传照片
	try {
		//统一编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("textml charset=utf-8");
		// 通过PrintWrite对象，将分析的结果返还给前台AJAX
		PrintWriter out = response.getWriter();
		// 设置表单类型，包含文件类型的字段
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// 设置上传路径
		String uploadFilePath = "H:\\images";
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items;
			String filePath = "";
			items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				// 获取每一张照片
				FileItem item = iter.next();
				if (!item.isFormField()) {
					// 获取文件名
					String fileName = item.getName();
					if (fileName != null && !fileName.equals("")) {
						File saveFile = new File(uploadFilePath, fileName);
						filePath = saveFile.getPath();
						// 保存图
						item.write(saveFile);
						System.out.println("上传成功!");
						// 人脸识别
						Object result = FaceRecognize.faceRecognize(filePath);
						out.println(result);
						return;

					}

				}

			}

		}

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
