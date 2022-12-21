package net.flexberry.flexberrySampleSpring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Audited
@Table(schema = "public", name = "comment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "primarykey")
public class Comment {
    @Id
    @Column(name = "primarykey")
    private int primarykey;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commentdate")
    private Date commentDate;

    @Column(name = "commenttext")
    private String commentText;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Comment() {
        super();
    }
    public int getPrimarykey() {
        return primarykey;
    }
    public void setPrimarykey(int primarykey) {
        this.primarykey = primarykey;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
