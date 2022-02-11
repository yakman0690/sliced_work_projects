# Реальные проекты с обрезанным функционалом

Этот репозиторий представляет из себя "обрезанную" версию коннектора для УТМ (ЕГАИС).
Здесь отключен функционал обмена данными с серверм, на котором работают клиенты (поставлена заглушка для тестового получения JMS сообщения)

## DesktopAppsCommons и EgaisDomain
Вспомогательные проекты, в которых расположены основные объекты для работы.

## SlicedEgaisUtmConnector
Непосредственно программа-коннектор.

## SlicedEgaisUtmAppManager
Программа для обновления и запуска коннектора. При сборке упаковывается в exe для самостоятельной установки конечным пользователем.
