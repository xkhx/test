package xyz.minicold.nex.Bilibilis.interfaces;

import xyz.minicold.nex.Bilibilis.datas.VideoInfo;

public interface GetVideoinfointerface {
	public VideoInfo getvideoinfo(int coin, int danmaku, int favorite, int like, int reply, int view, int share,
			String title,String desc);
}
