1. **CallStats**: Этот класс представляет статистику звонков для конкретного абонента. Он содержит поле `totalTime`, которое хранит общую продолжительность звонков для данного абонента. Метод `addDuration` используется для добавления продолжительности каждого отдельного звонка к общей продолжительности. Метод `getTotalTime` возвращает общую продолжительность звонков.

2. **CDRGenerator**: Этот класс отвечает за генерацию CDR (Call Detail Record) файлов. В методе `generateCDRFile` создается новый файл и генерируется указанное количество записей в формате CDR. Каждая запись представляет собой случайно сгенерированный тип вызова, номер телефона, дату и время начала и окончания звонка. Генерация происходит в пределах одного года. Методы `getPhoneNumberFromDatabase` и `getRandomTimeWithinOneYear` используются для получения реальных номеров телефонов из базы данных и генерации случайного времени в пределах одного года соответственно.

3. **CDRReader**: Этот класс отвечает за чтение CDR файлов и агрегацию данных из них. Метод `readCDRFile` читает указанный CDR файл, анализирует каждую запись и агрегирует статистику звонков для каждого абонента. Результат агрегации представлен в виде карты, где ключ - номер телефона абонента, а значение - статистика звонков для этого абонента.

4. **DatabaseManager**: Этот класс отвечает за сохранение транзакций (звонков) в базу данных. Метод `saveTransaction` принимает номер телефона абонента, время начала и окончания звонка и сохраняет эту информацию в базу данных.

5. **Main**: Этот класс содержит метод `main`, который является точкой входа в приложение. В данном случае он используется для запуска генерации отчетов по умолчанию.

6. **SubscriberDatabase**: Этот класс представляет базу данных абонентов. Он хранит информацию о номерах телефонов абонентов. Методы `addSubscriber` и `getSubscriberData` используются для добавления и получения данных абонента соответственно.

7. **UDR**: Этот класс представляет отчет UDR (Usage Detail Record) для конкретного абонента. Он содержит информацию о номере телефона абонента и статистику входящих и исходящих звонков (объекты `CallStats`). Методы `addIncomingCall` и `addOutgoingCall` используются для добавления продолжительности входящих и исходящих звонков соответственно.

8. **UDRReportGenerator**: Этот класс отвечает за генерацию отчетов UDR. Методы `generateReport` используются для сохранения отчетов в формате JSON и вывода сводной информации о звонках для всех абонентов или для конкретного абонента.