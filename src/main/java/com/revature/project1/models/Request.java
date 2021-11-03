package com.revature.project1.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "e_id")
    private Employee employee_id;

    @Column
    String urgency;

    @Column
    long date;

    @Column
    long time;

    @Column
    String location;

    @ManyToOne
    @JoinColumn(name = "ev_id")
    private Events event_type;

    @Column
    String description;

    @Column
    long event_start_date;

    @Column
    int requested_cost;

    @Column()
    String attached_document;

    @ManyToOne
    @JoinColumn(name = "g_id")
    private Grades grading_format;

    @Column()
    int event_reimb_cost;

    @Column()
    boolean approved_by_ds;

    @Column()
    boolean approved_by_dh;


    @ManyToOne
    @JoinColumn(name = "b_id")
    private BCA bca_id;

    @Column()
    boolean approved_by_bca;

    public Request() {
    }

    public Request(int id, Employee employee_id, String urgency, long date, long time, String location, Events event_type, String description, long event_start_date, int requested_cost, String attached_document, Grades grading_format, int event_reimb_cost, boolean approved_by_ds, boolean approved_by_dh, BCA bca_id, boolean approved_by_bca) {
        this.id = id;
        this.employee_id = employee_id;
        this.urgency = urgency;
        this.date = date;
        this.time = time;
        this.location = location;
        this.event_type = event_type;
        this.description = description;
        this.event_start_date = event_start_date;
        this.requested_cost = requested_cost;
        this.attached_document = attached_document;
        this.grading_format = grading_format;
        this.event_reimb_cost = event_reimb_cost;
        this.approved_by_ds = approved_by_ds;
        this.approved_by_dh = approved_by_dh;
        this.bca_id = bca_id;
        this.approved_by_bca = approved_by_bca;
    }


    public Request(Employee employee_id, String urgency, long date, long time, String location, Events event_type, String description, long event_start_date, int requested_cost, String attached_document, Grades grading_format, int event_reimb_cost, boolean approved_by_ds, boolean approved_by_dh, BCA bca_id, boolean approved_by_bca) {
        this.employee_id = employee_id;
        this.urgency = urgency;
        this.date = date;
        this.time = time;
        this.location = location;
        this.event_type = event_type;
        this.description = description;
        this.event_start_date = event_start_date;
        this.requested_cost = requested_cost;
        this.attached_document = attached_document;
        this.grading_format = grading_format;
        this.event_reimb_cost = event_reimb_cost;
        this.approved_by_ds = approved_by_ds;
        this.approved_by_dh = approved_by_dh;
        this.bca_id = bca_id;
        this.approved_by_bca = approved_by_bca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Events getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Events event_type) {
        this.event_type = event_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEvent_start_date() {
        return event_start_date;
    }

    public void setEvent_start_date(long event_start_date) {
        this.event_start_date = event_start_date;
    }

    public int getRequested_cost() {
        return requested_cost;
    }

    public void setRequested_cost(int requested_cost) {
        this.requested_cost = requested_cost;
    }

    public String getAttached_document() {
        return attached_document;
    }

    public void setAttached_document(String attached_document) {
        this.attached_document = attached_document;
    }

    public Grades getGrading_format() {
        return grading_format;
    }

    public void setGrading_format(Grades grading_format) {
        this.grading_format = grading_format;
    }

    public int getEvent_reimb_cost() {
        return event_reimb_cost;
    }

    public void setEvent_reimb_cost(int event_reimb_cost) {
        this.event_reimb_cost = event_reimb_cost;
    }

    public boolean isApproved_by_ds() {
        return approved_by_ds;
    }

    public void setApproved_by_ds(boolean approved_by_ds) {
        this.approved_by_ds = approved_by_ds;
    }

    public boolean isApproved_by_dh() {
        return approved_by_dh;
    }

    public void setApproved_by_dh(boolean approved_by_dh) {
        this.approved_by_dh = approved_by_dh;
    }

    public BCA getBca_id() {
        return bca_id;
    }

    public void setBca_id(BCA bca_id) {
        this.bca_id = bca_id;
    }

    public boolean isApproved_by_bca() {
        return approved_by_bca;
    }

    public void setApproved_by_bca(boolean approved_by_bca) {
        this.approved_by_bca = approved_by_bca;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return getId() == request.getId() && getDate() == request.getDate() && getTime() == request.getTime() && getEvent_start_date() == request.getEvent_start_date() && getRequested_cost() == request.getRequested_cost() && getEvent_reimb_cost() == request.getEvent_reimb_cost() && isApproved_by_ds() == request.isApproved_by_ds() && isApproved_by_dh() == request.isApproved_by_dh() && isApproved_by_bca() == request.isApproved_by_bca() && Objects.equals(getEmployee_id(), request.getEmployee_id()) && Objects.equals(getUrgency(), request.getUrgency()) && Objects.equals(getLocation(), request.getLocation()) && Objects.equals(getEvent_type(), request.getEvent_type()) && Objects.equals(getDescription(), request.getDescription()) && Objects.equals(getAttached_document(), request.getAttached_document()) && Objects.equals(getGrading_format(), request.getGrading_format()) && Objects.equals(getBca_id(), request.getBca_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmployee_id(), getUrgency(), getDate(), getTime(), getLocation(), getEvent_type(), getDescription(), getEvent_start_date(), getRequested_cost(), getAttached_document(), getGrading_format(), getEvent_reimb_cost(), isApproved_by_ds(), isApproved_by_dh(), getBca_id(), isApproved_by_bca());
    }


    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", urgency='" + urgency + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", event_type=" + event_type +
                ", description='" + description + '\'' +
                ", event_start_date=" + event_start_date +
                ", requested_cost=" + requested_cost +
                ", attached_document='" + attached_document + '\'' +
                ", grading_format=" + grading_format +
                ", event_reimb_cost=" + event_reimb_cost +
                ", approved_by_ds=" + approved_by_ds +
                ", approved_by_dh=" + approved_by_dh +
                ", bca_id=" + bca_id +
                ", approved_by_bca=" + approved_by_bca +
                '}';
    }
}
