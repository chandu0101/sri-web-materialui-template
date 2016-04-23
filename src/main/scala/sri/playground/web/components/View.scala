package sri.playground.web.components

import chandu0101.macros.tojs.JSMacro
import sri.core.{React, ReactNode}
import scala.scalajs.js.Dynamic.{literal => json}

import scala.scalajs.js
import scala.scalajs.js.{Function1, UndefOr}

case class View(style: js.UndefOr[js.Any]= js.undefined, key: js.UndefOr[String] = js.undefined) {

  def apply(children: ReactNode*) = {
    val props = JSMacro[View](this)
    React.createElement("div", props, children: _*)
  }
}
