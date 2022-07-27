package bwina.java_social_server.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String messageContent;

    @NonNull
    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_message_id", referencedColumnName = "id")
    private Profile sender;

    @NonNull
    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_message_id", referencedColumnName = "id")
    private Profile receiver;

    @NonNull
    private Timestamp dateSent;
}
