package net.flexberry.flexberrySampleSpring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.UUID;

@Entity
@Audited
@Table(schema = "public", name = "comment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "primarykey")
public class Comment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "primarykey")
    private UUID primarykey;

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
    public UUID getPrimarykey() {
        return primarykey;
    }
    public void setPrimarykey(UUID primarykey) {
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
