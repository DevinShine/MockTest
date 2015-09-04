package com.shadev.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shadev.mocktest.BuildConfig;
import com.shadev.mocktest.model.Repo;
import com.shadev.mocktest.rest.Github;
import com.shadev.mocktest.rest.GithubFactory;
import com.squareup.okhttp.OkHttpClient;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.httpclient.FakeHttp;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;
import rx.Observable;

/**
 * Created by devinshine on 15/9/4.
 *
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class) @Config(constants = BuildConfig.class)
public class ApiTest {

    Github mGithub = GithubFactory.getSingleton();//走真实数据的接口

    Github mMockGithub;
    Client mMockClient;

    @Before public void setUp() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();
        mMockClient = mock(Client.class);
        RequestInterceptor requestInterceptor = request -> request.addHeader("User-Agent",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        RestAdapter restAdapter = new RestAdapter.Builder().setClient(mMockClient)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setEndpoint("https://api.github.com")
            .setConverter(new GsonConverter(gson))
            .setRequestInterceptor(requestInterceptor)
            .build();
        mMockGithub = restAdapter.create(Github.class);
    }

    //Test1
    @Test public void reposTest1() throws IOException {
        String mockJsonResult =
            "[{\"id\":19669199,\"name\":\"AnimationDemo\",\"full_name\":\"DevinShine/AnimationDemo\",\"owner\":{\"login\":\"DevinShine\",\"id\":7385819,\"avatar_url\":\"https://avatars.githubusercontent.com/u/7385819?v=3\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/DevinShine\",\"html_url\":\"https://github.com/DevinShine\",\"followers_url\":\"https://api.github.com/users/DevinShine/followers\",\"following_url\":\"https://api.github.com/users/DevinShine/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/DevinShine/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/DevinShine/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/DevinShine/subscriptions\",\"organizations_url\":\"https://api.github.com/users/DevinShine/orgs\",\"repos_url\":\"https://api.github.com/users/DevinShine/repos\",\"events_url\":\"https://api.github.com/users/DevinShine/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/DevinShine/received_events\",\"type\":\"User\",\"site_admin\":false},\"private\":false,\"html_url\":\"https://github.com/DevinShine/AnimationDemo\",\"description\":\"\",\"fork\":false,\"url\":\"https://api.github.com/repos/DevinShine/AnimationDemo\",\"forks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/forks\",\"keys_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/teams\",\"hooks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/hooks\",\"issue_events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/events\",\"assignees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/tags\",\"blobs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/languages\",\"stargazers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/stargazers\",\"contributors_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contributors\",\"subscribers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscribers\",\"subscription_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscription\",\"commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/merges\",\"archive_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/downloads\",\"issues_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/releases{/id}\",\"created_at\":\"2014-05-11T15:05:26Z\",\"updated_at\":\"2014-05-11T15:16:59Z\",\"pushed_at\":\"2014-05-11T15:16:58Z\",\"git_url\":\"git://github.com/DevinShine/AnimationDemo.git\",\"ssh_url\":\"git@github.com:DevinShine/AnimationDemo.git\",\"clone_url\":\"https://github.com/DevinShine/AnimationDemo.git\",\"svn_url\":\"https://github.com/DevinShine/AnimationDemo\",\"homepage\":null,\"size\":1556,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":0,\"mirror_url\":null,\"open_issues_count\":0,\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"master\"}]";
        FakeHttp.addPendingHttpResponse(200, mockJsonResult);

        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.print(result);
        assertThat(result, is(mockJsonResult));
    }

    //Test2 这个是走真实网络返回的数据
    @Test public void reposTest2() {
        List<Repo> list = mGithub.listRepos("devinshine");
        assertThat(list.size(), is(not(0)));
        System.out.print(list.size());
    }

    //Test3 这个是走真实网络返回的数据
    @Test public void reposTestByObservable() {
        int size = mGithub.listRepos2Observable("devinshine")
            .flatMap(Observable::from)
            .count()
            .toBlocking()
            .single();
        assertThat(size, is(not(0)));
        System.out.print(size);

        //下面代码是会报错的
        //TestSubscriber<Repo> testSubscriber = new TestSubscriber<>();
        //mGithub.listRepos2Observable("devinshine")
        //    .flatMap(Observable::from)
        //    .subscribe(testSubscriber);
        //assertThat(testSubscriber.getOnNextEvents().size(),is(not(0)));
    }

    //Test4 这是走模拟数据
    @Test public void reposTestByMockClient() throws IOException {
        String mockJsonResult =
            "[{\"id\":19669199,\"name\":\"AnimationDemo\",\"full_name\":\"DevinShine/AnimationDemo\",\"owner\":{\"login\":\"DevinShine\",\"id\":7385819,\"avatar_url\":\"https://avatars.githubusercontent.com/u/7385819?v=3\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/DevinShine\",\"html_url\":\"https://github.com/DevinShine\",\"followers_url\":\"https://api.github.com/users/DevinShine/followers\",\"following_url\":\"https://api.github.com/users/DevinShine/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/DevinShine/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/DevinShine/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/DevinShine/subscriptions\",\"organizations_url\":\"https://api.github.com/users/DevinShine/orgs\",\"repos_url\":\"https://api.github.com/users/DevinShine/repos\",\"events_url\":\"https://api.github.com/users/DevinShine/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/DevinShine/received_events\",\"type\":\"User\",\"site_admin\":false},\"private\":false,\"html_url\":\"https://github.com/DevinShine/AnimationDemo\",\"description\":\"\",\"fork\":false,\"url\":\"https://api.github.com/repos/DevinShine/AnimationDemo\",\"forks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/forks\",\"keys_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/teams\",\"hooks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/hooks\",\"issue_events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/events\",\"assignees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/tags\",\"blobs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/languages\",\"stargazers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/stargazers\",\"contributors_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contributors\",\"subscribers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscribers\",\"subscription_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscription\",\"commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/merges\",\"archive_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/downloads\",\"issues_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/releases{/id}\",\"created_at\":\"2014-05-11T15:05:26Z\",\"updated_at\":\"2014-05-11T15:16:59Z\",\"pushed_at\":\"2014-05-11T15:16:58Z\",\"git_url\":\"git://github.com/DevinShine/AnimationDemo.git\",\"ssh_url\":\"git@github.com:DevinShine/AnimationDemo.git\",\"clone_url\":\"https://github.com/DevinShine/AnimationDemo.git\",\"svn_url\":\"https://github.com/DevinShine/AnimationDemo\",\"homepage\":null,\"size\":1556,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":0,\"mirror_url\":null,\"open_issues_count\":0,\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"master\"}]";
        Response response =
            new Response("http://www.baidu.com", 200, "nothing", Collections.EMPTY_LIST,
                new TypedByteArray("application/json", mockJsonResult.getBytes()));
        when(mMockClient.execute(Matchers.anyObject())).thenReturn(response);

        int size = mMockGithub.listRepos2Observable("devinshine")
            .flatMap(Observable::from)
            .count()
            .toBlocking()
            .single();
        assertThat(size, is(1));
    }
}
