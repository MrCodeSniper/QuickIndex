package chenhong.com.quickindex.Bean;

import chenhong.com.quickindex.Utils.PinYinUtil;

//再创建一个成员变量pinyin让每个字有对应拼音不用每次都调用比较直接取
public class Friend implements Comparable<Friend> {
	private String name;
	private String pinyin;

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Friend(String name) {
		this.name = name;
		setPinyin(PinYinUtil.getPinYin(name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int compareTo(Friend another) {
		String anotherPinyin=PinYinUtil.getPinYin(another.getName());
		return	getPinyin().compareTo(anotherPinyin);
	}
}
