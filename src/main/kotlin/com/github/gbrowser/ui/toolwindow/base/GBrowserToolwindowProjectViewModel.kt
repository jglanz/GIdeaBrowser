package com.github.gbrowser.ui.toolwindow.base

import com.github.gbrowser.ui.toolwindow.model.GBrowserViewModel
import kotlinx.coroutines.flow.StateFlow
import org.jetbrains.annotations.Nls

/**
 * Represent a view model of a gbrowser toolwindow with selected project (for GitHub it is a repository).
 *
 * VM is mostly used for UI creation in [GBrowserTabsComponentFactory]
 * to create the gbrowser list component or other tabs.
 *
 * @param T tab type
 * @param TVM tab view model
 */
interface GBrowserToolwindowProjectViewModel<T : GBrowserTab, TVM : GBrowserTabViewModel> {

  val browserVm: GBrowserViewModel
  /**
   * Presentable name for the project which context is hold here.
   * Used in toolwindow UI places like gbrowser list tab title.
   */
  val projectName: @Nls String


  /**
   * State of displayed gbrowser tabs besides the list
   */
  val tabs: StateFlow<GBrowserToolwindowTabs<T, TVM>>

  /**
   * Pass a [tab] to select certain gbrowser tab or null to select list tab
   */
  fun selectTab(tab: T?)

  fun closeTab(tab: T)
}