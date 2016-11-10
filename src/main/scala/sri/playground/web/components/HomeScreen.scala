package sri.playground.web.components

import sri.core.{ReactComponent, ReactElement}
import sri.extra.web.components.materialui._
import sri.extra.web.components.materialui.components._
import sri.web.all._
import sri.web.styles.WebStyleSheet
import sri.web.vdom.htmltags._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{UndefOr => U, undefined}

object HomeScreen {

  case class State(theme: MuiRawTheme = Mui.Styles.LightRawTheme, tabValue: String = "light")

  @ScalaJSDefined
  class Component extends ReactComponent[Unit, State] {

    initialState(State())

    def render() = {
      MuiRootComponent(state.theme)(
        div()(
          MuiAppBar(title = "Sri-Web-MaterialUI-Template")(),
          div(style = styles.container)(
            MuiTabs(value = state.tabValue, onChange = handleTabChange _)(
              MuiTab(label = "Default Theme", value = "light")(),
              MuiTab(label = "Dark Theme", value = "dark")()
            ),
            div(style = styles.content)(
              div(style = styles.horizontal)(
                div(style = styles.itemsGroup)(
                  div(style = styles.item)(MuiRaisedButton(disabled = true, label = "DISABLED")()),
                  div(style = styles.item)(MuiRaisedButton(label = "SECONDARY", secondary = true)()),
                  div(style = styles.item)(MuiRaisedButton(label = "PRIMARY", primary = true)()),
                  div(style = styles.item)(MuiRaisedButton(label = "DEFAULT")())
                ),
                div(style = styles.itemsGroup)(
                  div(style = styles.item)(MuiTextField(floatingLabelText = "Enter Name")()),
                  div(style = styles.item)(MuiDatePicker(hintText = "Date picker", mode = PortraitLandscape.landscape)),
                  //                  div(style = styles.item)(MuiRadioButton(label = "Radio Select")()),
                  div(style = styles.item)(MuiCheckbox(label = "Check Me"))
                ),
                div(style = styles.itemsGroup)(
                  div(style = styles.item)(MuiPaper(style = styles.paper)("Mui Paper")),
                  div(style = styles.item)(MuiPaper(style = styles.paper,zDepth = ZDepth._3)("Mui Paper with ZDepth 3")),
                  div(style = styles.item)(MuiPaper(circle = true,style = styles.paper)())
                )
              )
            )
          )
        )
      )
    }

    def handleTabChange(value: String, event: ReactEventH, tab: ReactElement) = {
      val theme = if (value == "dark") Mui.Styles.DarkRawTheme else Mui.Styles.LightRawTheme
      setState(state.copy(theme = theme, tabValue = value))
    }

  }

  object styles extends WebStyleSheet {

    val container = style(
      display.flex,
      flexDirection.column,
      flex := 1,
      padding := 70,
      paddingTop := 120)

    val vertical = style(display.flex,
      flexDirection.column)

    val horizontal = style(display.flex,
      flexDirection.row)

    val content = styleE(vertical)(margin := 30, flex := 1)

    val item = style(marginTop := 15)

    val itemsGroup = styleE(vertical)(alignItems.center, marginRight := 70)

    val paper = style(width := 100, height := 100,textAlign.center,display.`inline-block`)

    val slider = style(width := "100%", marginTop := 20)

  }



  def apply(key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, Unit] = null) = makeElementNoProps[Component](key = key, ref = ref)
}