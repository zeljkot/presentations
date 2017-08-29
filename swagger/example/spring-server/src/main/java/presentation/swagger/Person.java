package presentation.swagger;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * User of the app
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String name = null;

    private Integer age = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First and last name
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "First and last name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get age
     *
     * @return age
     **/
    @ApiModelProperty(value = "")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

