package sri.playground.web.router

import sri.core.ReactElement
import sri.playground.web.components.HomeScreen
import sri.web.router._

object AppRouter {

  object HomePage extends WebStaticPage

  object config extends WebRouterConfig {

    override val history: History = HistoryFactory.browserHistory(new HistoryOptions(basename = "/sri-web-materialui"))

    override val initialRoute: (WebStaticPage, WebRoute) = defineInitialRoute(HomePage, (route: WebRoute) => HomeScreen())

    override def renderScene(route: WebRoute): ReactElement = {
      super.renderScene(route)
    }

    override val notFound = WebRouteNotFound(initialRoute._1)
  }

  val router = WebRouter(config)
}
