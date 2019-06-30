package xyz.minicold.nex.Bilibilis.datas;

public class VideoInfo {
	public int coin;
	public int danmaku;// 弹幕
	public int favorite;// 喜欢
	public int like;// 未知
	public int reply;// 回复
	public int view;// 观看
	public int share;// 分享
	public String title;// 标题
	public String desc;// 描述

	public String toString() {
		return "视频名称:" + title + "\n硬币数:" + coin + "\n收藏数:" + favorite + "\n点赞数:" + like + "\n回复数:" + reply + "\n观看数:"
				+ view + "\n分享数:" + share + "\n弹幕数:" + danmaku + "\n描述:" + desc;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getDanmaku() {
		return danmaku;
	}

	public void setDanmaku(int danmaku) {
		this.danmaku = danmaku;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
