package com.billshare.app.bill.domain

import com.billshare.app.percentage.domain.Percentage
import com.fasterxml.jackson.annotation.JsonView
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "bill")
data class Bill (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(BillView.BillSummary::class)
        val id: Long? = null,

        @Column(name = "amount")
        @JsonView(BillView.BillSummary::class)
        val price: Double? = null,

        @Column(name = "name")
        @JsonView(BillView.BillSummary::class)
        val name: String? = null,

        @Column(name = "due_date")
        @Temporal(TemporalType.TIMESTAMP)
        @JsonView(BillView.BillSummary::class)
        val dueDate: Date? = null,

        @OneToMany
        @JoinColumn(name = "bill_id")
        @JsonView(BillView.ExtendedBillSummary::class)
        val percentages: List<Percentage> = ArrayList<Percentage>()

)