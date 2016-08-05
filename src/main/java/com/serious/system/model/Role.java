package com.serious.system.model;

import java.util.Date;

public class Role {
	
    private Integer id;

    private String role_name;

    private String description;

    private Date createtime;
    
    private Date updatetime;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getRole_name()
	{
		return role_name;
	}

	public void setRole_name(String role_name)
	{
		this.role_name = role_name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public Date getUpdatetime()
	{
		return updatetime;
	}

	public void setUpdatetime(Date updatetime)
	{
		this.updatetime = updatetime;
	}
	
}