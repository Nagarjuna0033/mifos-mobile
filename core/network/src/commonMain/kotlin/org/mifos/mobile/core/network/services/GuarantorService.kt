/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-mobile/blob/master/LICENSE.md
 */
package org.mifos.mobile.core.network.services

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow
import org.mifos.mobile.core.model.entity.guarantor.GuarantorApplicationPayload
import org.mifos.mobile.core.model.entity.guarantor.GuarantorPayload
import org.mifos.mobile.core.model.entity.guarantor.GuarantorTemplatePayload

interface GuarantorService {
    @GET("loans/{loanId}/guarantors/template")
    fun getGuarantorTemplate(@Path("loanId") loanId: Long): Flow<GuarantorTemplatePayload>

    @GET("loans/{loanId}/guarantors")
    fun getGuarantorList(@Path("loanId") loanId: Long): Flow<List<GuarantorPayload>>

    @POST("loans/{loanId}/guarantors")
    suspend fun createGuarantor(
        @Path("loanId") loanId: Long,
        @Body payload: GuarantorApplicationPayload?,
    ): HttpResponse

    @PUT("loans/{loanId}/guarantors/{guarantorId}")
    suspend fun updateGuarantor(
        @Body payload: GuarantorApplicationPayload?,
        @Path("loanId") loanId: Long,
        @Path("guarantorId") guarantorId: Long,
    ): HttpResponse

    @DELETE("loans/{loanId}/guarantors/{guarantorId}")
    suspend fun deleteGuarantor(
        @Path("loanId") loanId: Long,
        @Path("guarantorId") guarantorId: Long,
    ): HttpResponse
}
