package com.billshare.app.bill.domain

import com.fasterxml.jackson.annotation.JsonView
import java.util.*
import javax.persistence.*
import com.billshare.app.access.user.domain.User;
import com.billshare.app.bill.view.models.BillView

@Entity
@Table(name = "Bills")
data class Bill (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(BillView.BillSummary::class)
        val id: Long? = null,

        @Column(name = "price")
        @JsonView(BillView.BillSummary::class)
        val price: Double? = null,

        @Column(name = "name")
        @JsonView(BillView.BillSummary::class)
        val name: String? = null,

        @Column(name = "dueDate")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonView(BillView.BillSummary::class)
        val dueDate: Date? = null,

        @ManyToOne
        @JoinColumn(name = "userId")
        var user: User? = null
)
