package presentation.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * User of the app
 */
@Entity
@ApiModel(description = "User of the app")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(example = "Pero Vragec")
    private String name = null;

    @ApiModelProperty(example = "46")
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

