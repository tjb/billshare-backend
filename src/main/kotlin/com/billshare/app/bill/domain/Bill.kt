package com.billshare.app.bill.domain

import com.billshare.app.percentage.domain.Percentage
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "bill")
data class Bill (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long? = null,

        @Column(name = "amount")
        val price: Double? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "due_date")
        @Temporal(TemporalType.TIMESTAMP)
        val dueDate: Date? = null,

        @OneToMany
        @JoinColumn(name = "percentage_id", referencedColumnName = "id")
        val percentages: List<Percentage> = ArrayList<Percentage>()

)