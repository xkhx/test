package xyz.minicold.nex.Bilibilis.interfaces;

import xyz.minicold.nex.Bilibilis.datas.VideoInfo;

public class GetVideoinfoCollect implements GetVideoinfointerface{

	public VideoInfo getvideoinfo(int coin, int danmaku, int favorite, int like, int reply, int view, int share,
			String title,String desc) {
VideoInfo videoInfo=new VideoInfo();
videoInfo.coin=coin;
videoInfo.danmaku=danmaku;
videoInfo.favorite=favorite;
videoInfo.like=like;
videoInfo.reply=reply;
videoInfo.share=share;
videoInfo.title=title;
videoInfo.view=view;
videoInfo.desc=desc;
		return videoInfo;
	}
	

}
