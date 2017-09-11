package com.billshare.app.percentage.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PercentageRepository: JpaRepository<Percentage, Long> {
}