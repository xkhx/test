package xyz.minicold.nex.Bilibilis;

import java.awt.Adjustable;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.MenuItem;
import java.awt.Scrollbar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.JTextComponent;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import xyz.minicold.cobili.Main;
import xyz.minicold.nex.Bilibilis.datas.VideoInfo;
import xyz.minicold.nex.Bilibilis.interfaces.GetVideoinfoCollect;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RGBImageFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.TextField;
import org.jdesktop.swingx.prompt.BuddyButton;
import org.jdesktop.swingx.table.LabelProperties;
import com.sun.java.swing.plaf.motif.MotifScrollBarButton;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JTextPane;

public class App {
	private JFrame frmBilibili;
	private JTextField textField;
	public static HashMap<Integer, Integer> SSV=new HashMap<Integer, Integer>();

	public static TextArea textArea_1=null;
	private JTextField textField_1;
	public static JButton button_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private 	JLabel  	 label_9= new JLabel();;
	private JProgressBar progressBar=new JProgressBar();
		
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmBilibili.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBilibili = new JFrame();
		frmBilibili.setTitle("Bilibili工具箱");
		frmBilibili.setBounds(100, 100, 585, 504);
		frmBilibili.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBilibili.getContentPane().setLayout(null);
        JFrame.setDefaultLookAndFeelDecorated(true);


     
        
        try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("123\r\n123");
		
		JPanel zhuye=new JPanel();
		tabbedPane.addTab("主页", zhuye);
		zhuye.setLayout(null);
		
		JButton button_3 = new JButton("开始播放");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Music mus=new Music();
				mus.plays();
			}
		});
		button_3.setBounds(137, 343, 98, 28);
		zhuye.add(button_3);
		
		Label label_4 = new Label("Version");
		label_4.setAlignment(Label.CENTER);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 41));
		label_4.setBounds(10, 10, 520, 64);
		zhuye.add(label_4);
		
		Label label_5 = new Label("1.0.0");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 41));
		label_5.setAlignment(Label.CENTER);
		label_5.setBounds(10, 80, 520, 64);
		zhuye.add(label_5);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("by.MCqie");
		lblNewJgoodiesLabel.setIcon(new ImageIcon(App.class.getResource("/com/jtattoo/plaf/icons/workplace_16x16.png")));
		lblNewJgoodiesLabel.setBounds(419, 150, 111, 18);
		zhuye.add(lblNewJgoodiesLabel);
		
		JButton button_4 = new JButton("停止播放");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Music mus=new Music();
				mus.waits();
			}
		});
		button_4.setBounds(299, 343, 98, 28);
		zhuye.add(button_4);
		JPanel payemian=new JPanel();
		tabbedPane.addTab("爬具体视频页面", payemian);
		payemian.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(49, 10, 97, 21);
		payemian.add(textField);
		textField.setColumns(10);
		
		JLabel lblAv = new JLabel("AV号");
		lblAv.setBounds(10, 13, 54, 15);
		payemian.add(lblAv);
		final TextArea textArea = new TextArea();
		JButton button = new JButton("开始");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				String s="https://api.bilibili.com/x/web-interface/archive/stat?aid="+textField.getText();
				String ss="https://api.bilibili.com/x/web-interface/view?aid="+textField.getText();
				String Danmu="https://api.bilibili.com/x/v1/dm/list.so?oid="+textField.getText();
				System.out.println(Main.gethttpext(Danmu));
				JSONObject jsonss=JSONObject.parseObject(Main.gethttpext(ss));
				JSONObject jsonsss=JSONObject.parseObject(jsonss.getString("data"));
				JSONObject json=JSONObject.parseObject(Main.gethttpext(s));
				JSONObject jsons=JSONObject.parseObject(json.getString("data"));
				System.out.println(jsonsss.toString());
				VideoInfo videoinfo= new GetVideoinfoCollect().getvideoinfo(
						jsons.getInteger("coin"), 
						jsons.getInteger("danmaku"),
						jsons.getInteger("favorite"),
						jsons.getInteger("like"), 
						jsons.getInteger("reply"),
						jsons.getInteger("view"),
						jsons.getInteger("share"), 
						jsonsss.getString("title"),
						jsonsss.getString("desc")
						);
				textArea.setText(  videoinfo.toString());
				textArea.repaint();
								}catch (Exception e) {
					Error.errors(e);
				}
			}
		});
		button.setBounds(158, 9, 65, 23);
		payemian.add(button);
		
		textArea.setText("无数据");
		textArea.setBounds(10, 37, 520, 337);
		payemian.add(textArea);
		
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBounds(10, 10, 549, 417);
		frmBilibili.getContentPane().add(tabbedPane);
		
		JPanel pafanju=new JPanel();
		tabbedPane.addTab("爬番剧", pafanju);
		pafanju.setLayout(null);
		
		JButton button_1 = new JButton("获取");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				JSONObject jsons=JSONObject.parseObject(Main.gethttpext("https://bangumi.bilibili.com/api/timeline_v2_global"));
				JSONArray json2=JSONArray.parseArray(jsons.get("result").toString());
				System.out.println((Main.gethttpext("https://bangumi.bilibili.com/api/timeline_v2_global")));
				textArea_1.setText("Bilibili最新更新番剧");
				for(int x = 0;x<json2.size();x++){
					SSV.put(x+1, JSONObject.parseObject(json2.get(x).toString()).getInteger("season_id"));
					//JSONObject.parseObject(json2.get(x).toString()).getInteger("season_id");
				String s=(x+1)+":"+JSONObject.parseObject(json2.get(x).toString()).getString("title")+"---------热度："+(JSONObject.parseObject(json2.get(x).toString()).getIntValue("favorites")+JSONObject.parseObject(json2.get(x).toString()).getIntValue("danmaku_count")*2);
				 textArea_1.setText(textArea_1.getText()+"\n"+s);
					
				}
				System.out.println("");
				button_2.setEnabled(true);
				}catch (Exception e) {
					Error.errors(e);
				}
				
			}
		});
		button_1.setBounds(0, 0, 98, 28);
		pafanju.add(button_1);
		
		textArea_1 = new TextArea();
		textArea_1.setBounds(10, 34, 520, 339);
		pafanju.add(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setText("输入番剧编号");
		textField_1.setBounds(306, 3, 114, 22);
		pafanju.add(textField_1);
		textField_1.setColumns(10);
		
		button_2 = new JButton("进入");
		button_2.setEnabled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				int SSvid=SSV.get(Integer.valueOf(textField_1.getText()));
				
				try {
					browse2("https://www.bilibili.com/bangumi/play/ss"+SSvid);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				}catch (Exception e) {
					Error.errors(e);
				}
			}
		});
		button_2.setBounds(432, 0, 98, 28);
		pafanju.add(button_2);
		
		JPanel about=new JPanel();
		tabbedPane.addTab("关于此软件", about);
		about.setLayout(null);
		
		Label label = new Label("design by. MCqie");
		label.setBounds(422, 350, 108, 23);
		about.add(label);
		
		Label label_1 = new Label("Void_Chest");
		label_1.setBounds(39, 350, 108, 23);
		about.add(label_1);
		
		JLabel label_2 = DefaultComponentFactory.getInstance().createLabel("");
		label_2.setIcon(new ImageIcon(App.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		label_2.setBounds(12, 350, 21, 21);
		about.add(label_2);
		
		JLabel label_3 = new JLabel("bilibili工具箱");
		label_3.setBounds(220, 12, 118, 18);
		about.add(label_3);
		
		TextArea textArea_3 = new TextArea();
		textArea_3.setText("功能：\r\n1.获取具体的视频页面信息 （包括：投币数，点赞数 .etc)\r\n2.获取最新更新的番剧 并返回番剧热度");
		textArea_3.setFont(new Font("Dialog", Font.PLAIN, 32));
		textArea_3.setBounds(12, 36, 520, 298);
		about.add(textArea_3);
		
		
		JPanel imagep=new JPanel();
		tabbedPane.addTab("图片处理", imagep);
		imagep.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(77, 12, 451, 22);
		imagep.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
					
					int i =1;
					String path = textField_2.getText();		//要遍历的路径
					File file = new File(path);		//获取其file对象
					File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
					for(File f:fs){					//遍历File[]数组
						if(!f.isDirectory()) {		//若非目录(即文件)，则打印
							BufferedImage image = null;
							try {
								image = ImageIO.read(f);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
						

					
					for (int y = 0; y < image.getHeight(); y += 1) {
						progressBar.setValue(y);
						for (int x = 0; x < image.getWidth(); x++) {
							progressBar.setMaximum(image.getHeight());
							int RGB = image.getRGB(x, y);
							final int r = (RGB & 0xff0000) >> 16, g = (RGB & 0xff00) >> 8, b = RGB & 0xff;
							if(r>255-Integer.valueOf(label_9.getText()) &g>255-Integer.valueOf(label_9.getText()) &b>255-Integer.valueOf(label_9.getText())) {
								
								image.setRGB(x, y,((0xFF << 24)|(255 << 16)|(255 << 8)|255));
								
							}
							
							
						}
						}
					String out="";
					if(textField_3.getText().equals("")) {
						out=f.getPath()+"处理后"+".png";
					}
					File fs1=new File(out);
					BufferedImage im=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
					Graphics graphics=im.getGraphics();
					graphics.drawImage(image,0,0, null);
					im.flush();
					try {
						ImageIO.write(im,"png",fs1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
			}
					
				}
		
		}
		});
		btnNewButton.setBounds(204, 303, 98, 28);
		imagep.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(77, 43, 451, 22);
		imagep.add(textField_3);
		
		progressBar.setMaximum(1);
		progressBar.setBounds(12, 343, 516, 28);
		imagep.add(progressBar);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollBar.setValue(180);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {

			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				
				label_9.setText(""+(scrollBar.getValue()));
			}
		});
		scrollBar.setMaximum(255);
		scrollBar.setBounds(87, 77, 441, 17);
		imagep.add(scrollBar);
		
		JLabel label_6 = new JLabel("\u8F93\u5165\u4F4D\u7F6E");
		label_6.setBounds(2, 11, 69, 23);
		imagep.add(label_6);
		
		JLabel label_7 = new JLabel("\u8F93\u51FA\u4F4D\u7F6E");
		label_7.setBounds(2, 43, 69, 23);
		imagep.add(label_7);
		
		JLabel label_8 = new JLabel("\u529B\u5EA6\uFF1A");
		label_8.setBounds(2, 71, 42, 23);
		imagep.add(label_8);
		
		label_9.setText("Normal");
		label_9.setBounds(39, 71, 42, 23);
		imagep.add(label_9);
		
		JLabel lblNotice = new JLabel("Notice\uFF1A\u5F53\u8F93\u51FA\u4F4D\u7F6E\u4E3A\u7A7A\u65F6 \u9ED8\u8BA4\u8F93\u51FA\u5230\u8F93\u5165\u76EE\u5F55\u4E2D");
		lblNotice.setBounds(12, 106, 441, 23);
		imagep.add(lblNotice);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu= new JMenu("菜单");
		menu.add(new MenuItem("测试").getActionCommand());
		menuBar.add(menu);
		
		frmBilibili.setJMenuBar(menuBar);
	}
	private static void browse2(String url) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(url);
            desktop.browse(uri);
        }
    }
}
