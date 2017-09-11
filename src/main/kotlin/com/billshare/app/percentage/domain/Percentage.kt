package com.billshare.app.percentage.domain

import com.fasterxml.jackson.annotation.JsonView
import javax.persistence.*

@Entity
@Table(name = "percentage")
data class Percentage (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(PercentageView.PercentageSummary::class)
        val id: Long? = null,

        @Column(name = "percentage")
        @JsonView(PercentageView.PercentageSummary::class)
        val percentage: Double? = null

)