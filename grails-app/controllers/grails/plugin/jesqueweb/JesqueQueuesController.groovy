package grails.plugin.jesqueweb

class JesqueQueuesController extends JesqueController {

    def index = {
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Queues"

        model.queueList = queueInfoDao.queueInfos
        model.totalFailureCount = failureDao.count

        model
    }

    def detail = {
        def queueName = params.id
        def offset = 0
        def max = 20
        def model = [:]

        model.tabs = tabs
        model.activeTab = "Queues"

        model.subTabs = queueInfoDao.queueNames
        model.activeSubTab = queueName

        model.queue = queueInfoDao.getQueueInfo(queueName, offset, max)

        model
    }
}