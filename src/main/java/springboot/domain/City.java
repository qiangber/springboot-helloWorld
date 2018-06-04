package springboot.domain;

/**
 * Created by qiangber on 18-3-29.
 */
public class City {

    private Long id;

    private Long provinceId;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City() {}

    public City(Long id, Long provinceId, String name, String description) {
        this.id = id;
        this.provinceId = provinceId;
        this.name = name;
        this.description = description;
    }

    public City(Long provinceId, String name, String description) {
        this.provinceId = provinceId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
