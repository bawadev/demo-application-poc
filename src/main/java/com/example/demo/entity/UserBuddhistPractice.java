package com.example.demo.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import com.example.demo.enums.BuddhistPracticeEnum.DeedCategoryEnum;
import com.example.demo.enums.BuddhistPracticeEnum.EnterToHardPracticeEnum;
import com.example.demo.enums.BuddhistPracticeEnum.KnowledgeAbhiDhammaEnum;
import com.example.demo.enums.BuddhistPracticeEnum.OriginTypeEnum;
import com.example.demo.enums.BuddhistPracticeEnum.TimeInvestedEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "user_buddhist_practice")
@Data
public class UserBuddhistPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practice_id")
    private Long practiceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin")
    private OriginTypeEnum origin;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_invested_overall")
    private TimeInvestedEnum timeInvestedOverall;

    @Enumerated(EnumType.STRING)
    @Column(name = "deed_category_dana")
    private DeedCategoryEnum deedCategoryDana;

    @Enumerated(EnumType.STRING)
    @Column(name = "deed_category_seela")
    private DeedCategoryEnum deedCategorySeela;

    @Enumerated(EnumType.STRING)
    @Column(name = "deed_category_bhavana")
    private DeedCategoryEnum deedCategoryBhavana;

    @Enumerated(EnumType.STRING)
    @Column(name = "deed_category_other")
    private DeedCategoryEnum deedCategoryOther;

    @Column(name = "meditation_ana_pana_sathi_time")
    private Integer meditationAnaPanaSathiTime;

    @Column(name = "meditation_mayithree_time")
    private Integer meditationMayithreeTime;

    @Column(name = "body_awareness_time")
    private Integer bodyAwarenessTime;

    @Column(name = "meditation_other_time")
    private Integer meditationOtherTime;

    @Column(name = "meditation_teacher")
    private String meditationTeacher;

    @Column(name = "seela_pansil_time")
    private Integer seelaPansilTime;

    @Column(name = "seela_ata_sil_time")
    private Integer seelaAtaSilTime;

    @Column(name = "seela_other_time")
    private Integer seelaOtherTime;

    @Column(name = "dana_amount_animals")
    private Integer danaAmountAnimals;

    @Column(name = "dana_amount_people")
    private Integer danaAmountPeople;

    @Column(name = "dana_amount_sangha")
    private Integer danaAmountSangha;

    @Column(name = "sermon_listen_time")
    private Integer sermonListenTime;

    @Lob
    @Column(name = "sermon_speakers_details")
    private String sermonSpeakersDetails;

    @Enumerated(EnumType.STRING)
    @Column(name = "knowledge_abhi_dhamma")
    private KnowledgeAbhiDhammaEnum knowledgeAbhiDhamma;

    @Lob
    @Column(name = "description_of_your_self")
    private String descriptionOfYourSelf;

    @Enumerated(EnumType.STRING)
    @Column(name = "enter_to_hard_practice")
    private EnterToHardPracticeEnum enterToHardPractice;

    @NotNull
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "value_score")
    private Integer valueScore;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private BuddhistUsers user;
}