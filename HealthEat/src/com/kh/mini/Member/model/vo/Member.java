package com.kh.mini.Member.model.vo;

public class Member {
// 로그인단 구현을 위한 뼈
	private String id; 		//아이디 
	private String pwd; 	//비밀번
	private String name;	//이름 
	private int age;		//나이 
	private String gender;	//성별 
	private String profile;	//프로필 넣을지말지 고민중 
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pwd, String name, int age, String gender) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.profile = profile; //일단 매개변수에서 뺐음 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id : " + id + " pwd : " + pwd + " name : " + name + " age : " + age +" gender : " + gender ;
	}
	
	
	
	
}
