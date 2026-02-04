package api.project.structor.dto;

import api.project.structor.entity.bt.CourseStatus;

public interface ICourseDto {
    Long getId();
    String getTitle();
    CourseStatus getStatus();
}
