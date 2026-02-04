package api.project.structor.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageDto {
    private Integer size;
    private Integer page;
    private String sortBy;
    private String direction;
}
