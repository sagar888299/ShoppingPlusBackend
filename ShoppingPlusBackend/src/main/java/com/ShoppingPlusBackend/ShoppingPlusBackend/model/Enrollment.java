package com.ShoppingPlusBackend.ShoppingPlusBackend.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Enrollment")

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Student_ID" , nullable = false)
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "Course_ID" , nullable = false)
    private CourseModel course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

	public Enrollment(Long id, StudentModel student, CourseModel course) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
	}


	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}    

}
