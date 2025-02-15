/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/mobile-mobile/blob/master/LICENSE.md
 */
package org.mifos.mobile.feature.loan.loanAccount

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.mifos.mobile.core.designsystem.icons.MifosIcons
import org.mifos.mobile.core.designsystem.theme.MifosMobileTheme
import org.mifos.mobile.core.ui.utils.DevicePreviews
import org.mifos.mobile.feature.loan.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoanAccountDetailTopBar(
    navigateBack: () -> Unit,
    viewGuarantor: () -> Unit,
    updateLoan: () -> Unit,
    withdrawLoan: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.loan_account_details)) },
        navigationIcon = {
            IconButton(
                onClick = { navigateBack.invoke() },
            ) {
                Icon(
                    imageVector = MifosIcons.ArrowBack,
                    contentDescription = "Back Arrow",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = MifosIcons.MoreVert,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }

            DropdownMenu(
                expanded = showMenu,
                modifier = Modifier.padding(start = 16.dp, end = 32.dp),
                onDismissRequest = { showMenu = false },
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = stringResource(id = R.string.view_guarantor))
                    },
                    onClick = viewGuarantor,
                )
                DropdownMenuItem(
                    text = {
                        Text(text = stringResource(id = R.string.update_loan))
                    },
                    onClick = updateLoan,
                )
                DropdownMenuItem(
                    text = {
                        Text(text = stringResource(id = R.string.withdraw_loan))
                    },
                    onClick = withdrawLoan,
                )
            }
        },
    )
}

@DevicePreviews
@Composable
private fun LoanAccountDetailTopBarPreview() {
    MifosMobileTheme {
        LoanAccountDetailTopBar(
            navigateBack = {},
            viewGuarantor = {},
            updateLoan = {},
            withdrawLoan = {},
        )
    }
}
