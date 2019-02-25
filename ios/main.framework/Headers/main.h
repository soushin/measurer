#import <Foundation/Foundation.h>

@class MainGoogleAnalytics, MainSampleHttpClient, MainMeasurerHttpClient, MainKtor_client_coreHttpClient, MainSampleHttpClientConfig, MainSampleNapierLogger, MainKotlinThrowable, MainKtor_client_coreHttpClientConfig, MainKotlinUnit, MainKotlinx_coroutines_core_nativeCoroutineDispatcher, MainKtor_client_coreHttpClientEngineConfig, MainKtor_client_coreHttpReceivePipeline, MainKtor_client_coreHttpRequestPipeline, MainKtor_client_coreHttpResponsePipeline, MainKtor_client_coreHttpSendPipeline, MainKotlinArray, MainKtor_utilsAttributeKey, MainKotlinAbstractCoroutineContextElement, MainKtor_client_coreHttpResponseConfig, MainKtor_utilsPipeline, MainKtor_utilsPipelinePhase, MainKotlinx_ioCharset, MainKotlinx_ioCharsetDecoder, MainKotlinx_ioCharsetEncoder;

@protocol MainMeasurerClient, MainMeasurerLogger, MainKotlinx_coroutines_core_nativeCoroutineScope, MainKotlinCoroutineContext, MainKotlinx_ioCloseable, MainKtor_client_coreHttpClientEngine, MainKtor_utilsAttributes, MainKotlinCoroutineContextElement, MainKotlinCoroutineContextKey, MainKtor_client_coreHttpClientFeature, MainKotlinContinuationInterceptor, MainKotlinContinuation, MainKotlinx_coroutines_core_nativeRunnable, MainKotlinSuspendFunction2, MainKotlinIterator, MainKotlinSuspendFunction;

NS_ASSUME_NONNULL_BEGIN

@interface KotlinBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface KotlinBase (KotlinBaseCopying) <NSCopying>
@end;

__attribute__((objc_runtime_name("KotlinMutableSet")))
__attribute__((swift_name("KotlinMutableSet")))
@interface MainMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
__attribute__((swift_name("KotlinMutableDictionary")))
@interface MainMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((objc_runtime_name("KotlinNumber")))
__attribute__((swift_name("KotlinNumber")))
@interface MainNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((objc_runtime_name("KotlinByte")))
__attribute__((swift_name("KotlinByte")))
@interface MainByte : MainNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((objc_runtime_name("KotlinUByte")))
__attribute__((swift_name("KotlinUByte")))
@interface MainUByte : MainNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((objc_runtime_name("KotlinShort")))
__attribute__((swift_name("KotlinShort")))
@interface MainShort : MainNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((objc_runtime_name("KotlinUShort")))
__attribute__((swift_name("KotlinUShort")))
@interface MainUShort : MainNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((objc_runtime_name("KotlinInt")))
__attribute__((swift_name("KotlinInt")))
@interface MainInt : MainNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((objc_runtime_name("KotlinUInt")))
__attribute__((swift_name("KotlinUInt")))
@interface MainUInt : MainNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((objc_runtime_name("KotlinLong")))
__attribute__((swift_name("KotlinLong")))
@interface MainLong : MainNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((objc_runtime_name("KotlinULong")))
__attribute__((swift_name("KotlinULong")))
@interface MainULong : MainNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((objc_runtime_name("KotlinFloat")))
__attribute__((swift_name("KotlinFloat")))
@interface MainFloat : MainNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((objc_runtime_name("KotlinDouble")))
__attribute__((swift_name("KotlinDouble")))
@interface MainDouble : MainNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((objc_runtime_name("KotlinBoolean")))
__attribute__((swift_name("KotlinBoolean")))
@interface MainBoolean : MainNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GoogleAnalytics")))
@interface MainGoogleAnalytics : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)googleAnalytics __attribute__((swift_name("init()")));
@end;

__attribute__((swift_name("MeasurerHttpClient")))
@interface MainMeasurerHttpClient : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)errorStatusCode:(int32_t)statusCode __attribute__((swift_name("error(statusCode:)")));
@property (readonly) NSString *baseUrl;
@property (readonly) id<MainMeasurerClient> client;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SampleHttpClient")))
@interface MainSampleHttpClient : MainMeasurerHttpClient
- (instancetype)initWithCli:(MainKtor_client_coreHttpClient *)cli log:(id<MainMeasurerLogger>)log __attribute__((swift_name("init(cli:log:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SampleHttpClientConfig")))
@interface MainSampleHttpClientConfig : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)sampleHttpClientConfig __attribute__((swift_name("init()")));
@property (readonly) MainKtor_client_coreHttpClient *httpClient;
@end;

__attribute__((swift_name("MeasurerLogger")))
@protocol MainMeasurerLogger
@required
- (void)dMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("d(message:throwable:tag:)")));
- (void)eMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("e(message:throwable:tag:)")));
- (void)iMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("i(message:throwable:tag:)")));
- (void)vMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("v(message:throwable:tag:)")));
- (void)wMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("w(message:throwable:tag:)")));
- (void)wtfMessage:(NSString *)message throwable:(MainKotlinThrowable * _Nullable)throwable tag:(NSString * _Nullable)tag __attribute__((swift_name("wtf(message:throwable:tag:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SampleNapierLogger")))
@interface MainSampleNapierLogger : KotlinBase <MainMeasurerLogger>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MeasurerProxyKt")))
@interface MainMeasurerProxyKt : KotlinBase
+ (void)pageTrackingUa:(NSString *)ua __attribute__((swift_name("pageTracking(ua:)")));
+ (void)eventTrackingUa:(NSString *)ua __attribute__((swift_name("eventTracking(ua:)")));
@end;

__attribute__((swift_name("MeasurerClient")))
@protocol MainMeasurerClient
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineScope")))
@protocol MainKotlinx_coroutines_core_nativeCoroutineScope
@required
@property (readonly) id<MainKotlinCoroutineContext> coroutineContext;
@end;

__attribute__((swift_name("Kotlinx_ioCloseable")))
@protocol MainKotlinx_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface MainKtor_client_coreHttpClient : KotlinBase <MainKotlinx_coroutines_core_nativeCoroutineScope, MainKotlinx_ioCloseable>
- (instancetype)initWithEngine:(id<MainKtor_client_coreHttpClientEngine>)engine userConfig:(MainKtor_client_coreHttpClientConfig *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (MainKtor_client_coreHttpClient *)configBlock:(MainKotlinUnit *(^)(MainKtor_client_coreHttpClientConfig *))block __attribute__((swift_name("config(block:)")));
@property (readonly) id<MainKtor_utilsAttributes> attributes;
@property (readonly) MainKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@property (readonly) MainKtor_client_coreHttpClientEngineConfig *engineConfig;
@property (readonly) MainKtor_client_coreHttpReceivePipeline *receivePipeline;
@property (readonly) MainKtor_client_coreHttpRequestPipeline *requestPipeline;
@property (readonly) MainKtor_client_coreHttpResponsePipeline *responsePipeline;
@property (readonly) MainKtor_client_coreHttpSendPipeline *sendPipeline;
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface MainKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(MainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(MainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (MainKotlinArray *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
@property (readonly) MainKotlinThrowable * _Nullable cause;
@property (readonly) NSString * _Nullable message;
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol MainKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<MainKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<MainKotlinCoroutineContextElement> _Nullable)getKey:(id<MainKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<MainKotlinCoroutineContext>)minusKeyKey:(id<MainKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<MainKotlinCoroutineContext>)plusContext:(id<MainKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol MainKtor_client_coreHttpClientEngine <MainKotlinx_coroutines_core_nativeCoroutineScope, MainKotlinx_ioCloseable>
@required
@property (readonly) MainKtor_client_coreHttpClientEngineConfig *config;
@property (readonly) MainKotlinx_coroutines_core_nativeCoroutineDispatcher *dispatcher;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface MainKtor_client_coreHttpClientConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (MainKtor_client_coreHttpClientConfig *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(MainKotlinUnit *(^)(MainKtor_client_coreHttpClientEngineConfig *))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(MainKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installFeature:(id<MainKtor_client_coreHttpClientFeature>)feature configure:(MainKotlinUnit *(^)(id))configure __attribute__((swift_name("install(feature:configure:)")));
- (void)installKey:(NSString *)key block:(MainKotlinUnit *(^)(MainKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(MainKtor_client_coreHttpClientConfig *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL expectSuccess;
@property BOOL followRedirects;
@property BOOL useDefaultTransformers;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface MainKotlinUnit : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@end;

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol MainKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(MainKtor_utilsAttributeKey *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(MainKtor_utilsAttributeKey *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(MainKtor_utilsAttributeKey *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<MainKtor_utilsAttributeKey *> *allKeys;
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol MainKotlinCoroutineContextElement <MainKotlinCoroutineContext>
@required
@property (readonly) id<MainKotlinCoroutineContextKey> key;
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface MainKotlinAbstractCoroutineContextElement : KotlinBase <MainKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<MainKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol MainKotlinContinuationInterceptor <MainKotlinCoroutineContextElement>
@required
- (id<MainKotlinContinuation>)interceptContinuationContinuation:(id<MainKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<MainKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeCoroutineDispatcher")))
@interface MainKotlinx_coroutines_core_nativeCoroutineDispatcher : MainKotlinAbstractCoroutineContextElement <MainKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<MainKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)dispatchContext:(id<MainKotlinCoroutineContext>)context block:(id<MainKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<MainKotlinCoroutineContext>)context block:(id<MainKotlinx_coroutines_core_nativeRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (BOOL)isDispatchNeededContext:(id<MainKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (MainKotlinx_coroutines_core_nativeCoroutineDispatcher *)plusOther:(MainKotlinx_coroutines_core_nativeCoroutineDispatcher *)other __attribute__((swift_name("plus(other:)")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface MainKtor_client_coreHttpClientEngineConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property MainKotlinx_coroutines_core_nativeCoroutineDispatcher * _Nullable dispatcher;
@property BOOL pipelining;
@property (readonly) MainKtor_client_coreHttpResponseConfig *response;
@property int32_t threadsCount;
@end;

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface MainKtor_utilsPipeline : KotlinBase
- (instancetype)initWithPhase:(MainKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<MainKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(MainKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(MainKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));
- (void)insertPhaseAfterReference:(MainKtor_utilsPipelinePhase *)reference phase:(MainKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(MainKtor_utilsPipelinePhase *)reference phase:(MainKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(MainKtor_utilsPipelinePhase *)phase block:(id<MainKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (void)mergeFrom:(MainKtor_utilsPipeline *)from __attribute__((swift_name("merge(from:)")));
@property (readonly) id<MainKtor_utilsAttributes> attributes;
@property (readonly) BOOL isEmpty;
@property (readonly) NSArray<MainKtor_utilsPipelinePhase *> *items;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface MainKtor_client_coreHttpReceivePipeline : MainKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(MainKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<MainKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(MainKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface MainKtor_client_coreHttpRequestPipeline : MainKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(MainKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<MainKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(MainKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface MainKtor_client_coreHttpResponsePipeline : MainKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(MainKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<MainKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(MainKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface MainKtor_client_coreHttpSendPipeline : MainKtor_utilsPipeline
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithPhase:(MainKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<MainKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(MainKotlinArray *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface MainKotlinArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(id _Nullable (^)(MainInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (id _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<MainKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(id _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size;
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol MainKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientFeature")))
@protocol MainKtor_client_coreHttpClientFeature
@required
- (void)installFeature:(id)feature scope:(MainKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(feature:scope:)")));
- (id)prepareBlock:(MainKotlinUnit *(^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) MainKtor_utilsAttributeKey *key;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface MainKtor_utilsAttributeKey : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol MainKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<MainKotlinCoroutineContext> context;
@end;

__attribute__((swift_name("Kotlinx_coroutines_core_nativeRunnable")))
@protocol MainKotlinx_coroutines_core_nativeRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpResponseConfig")))
@interface MainKtor_client_coreHttpResponseConfig : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property MainKotlinx_ioCharset *defaultCharset;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface MainKtor_utilsPipelinePhase : KotlinBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (readonly) NSString *name;
@end;

__attribute__((swift_name("KotlinSuspendFunction")))
@protocol MainKotlinSuspendFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol MainKotlinSuspendFunction2 <MainKotlinSuspendFunction>
@required
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol MainKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Kotlinx_ioCharset")))
@interface MainKotlinx_ioCharset : KotlinBase
- (instancetype)initWith_name:(NSString *)_name __attribute__((swift_name("init(_name:)"))) __attribute__((objc_designated_initializer));
- (MainKotlinx_ioCharsetDecoder *)doNewDecoder __attribute__((swift_name("doNewDecoder()")));
- (MainKotlinx_ioCharsetEncoder *)doNewEncoder __attribute__((swift_name("doNewEncoder()")));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetDecoder")))
@interface MainKotlinx_ioCharsetDecoder : KotlinBase
- (instancetype)initWith_charset:(MainKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_ioCharsetEncoder")))
@interface MainKotlinx_ioCharsetEncoder : KotlinBase
- (instancetype)initWith_charset:(MainKotlinx_ioCharset *)_charset __attribute__((swift_name("init(_charset:)"))) __attribute__((objc_designated_initializer));
@end;

NS_ASSUME_NONNULL_END
