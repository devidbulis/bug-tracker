package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="project")
public class ProjectDTO implements Serializable
{
    private int id;
    private String name;
    private String description;

    public ProjectDTO(int id, String name,String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
}
