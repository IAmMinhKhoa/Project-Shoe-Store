package DTO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {

	
	//hàm này giúp ta khi add 1 tấm ảnh từ local máy, thì giúp resize vừa với label avatar
	public static Image resize (Image originalimg ,int width, int height) {
		Image resultimg = originalimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			return resultimg;
	}
	//hàm này giúp ta chuyển ảnh thành dạng byte số giúp lưu trự
	public static byte[] toByteArray(Image img, String type) throws IOException
	{
		BufferedImage bimage =new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics2D g=bimage.createGraphics();
		g.drawImage(img,0,0,null);
		g.dispose();
		
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		ImageIO.write(bimage, type, baos);
		byte[] imageInByte=baos.toByteArray();
		return imageInByte;
	}
	//hàm này giúp ta chuyển từ mảng byte thanh2 ảnh	
	public static Image  createImageFromByteArray(byte[] data, String type) throws IOException
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		//System.out.println(bis);
		BufferedImage bimage = ImageIO.read(bis);
		//System.out.println(bimage);
		Image img =bimage.getScaledInstance(bimage.getWidth(), bimage.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}
	
	
}
