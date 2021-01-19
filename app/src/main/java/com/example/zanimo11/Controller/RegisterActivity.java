package com.example.zanimo11.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zanimo11.Data.Client;
import com.example.zanimo11.Models.user;
import com.example.zanimo11.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity { public EditText nom_add;
    public EditText prenom_add;
    public EditText password_add;
    public EditText email_add;
    public EditText numtel_add;
    public Button Ajouter;

    Client client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nom_add = (EditText) findViewById(R.id.nom);
        prenom_add = (EditText)findViewById(R.id.prenom);
        password_add = (EditText) findViewById(R.id.motdepasse);
        email_add = (EditText) findViewById(R.id.mail);
        numtel_add = (EditText) findViewById(R.id.numtel);
        Ajouter = (Button) findViewById(R.id.Ajouter);
        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }
    public void adduser() {
        user user = new user();
        client= new Client();

        String nom = nom_add.getText().toString().trim();
        String prenom = prenom_add.getText().toString().trim();
        String password = password_add.getText().toString().trim();
        String email = email_add.getText().toString().trim();
        String numtel = numtel_add.getText().toString().trim();
        String imageUser="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAAflBMVEX///8AAAD8/Pz6+vr39/cKCgoEBATy8vI4ODguLi5xcXEMDAwcHBwxMTHX19chISHBwcFXV1d9fX1iYmIoKCh2dnZsbGzp6emQkJCysrLh4eFQUFC7u7tHR0cWFhaGhoaampqmpqbNzc3b29tJSUk+Pj6hoaGCgoK1tbWUlJQW5JmbAAANgklEQVR4nNVd6aKiOgw+IKsoi+zIrujx/V9wKGvZBNoCZ75/984MNDRJky9p/PkhhIejMqSedRxoN7ukRy+CABKDkuSjF4GPVKAo6vfoVWDjZHK5HNbRy8DG45qLQV344Z/Q9kOWHw/vtP+iEOBKQA7qBf8/23WsQGGpGpKR6Y5vH7XERXDKpYp0/T+8WFOocYRa/Dhyrd9wq9aYlP/5uF0nhKihWOqxKx5HLYcCNuT0ymakqP7y7c85aqdem/PzwzuXRWIUyNyjl96BW6+Ls39e4XIxAIz47/iyVKpXdX8I68QAuMT0/Dv2AGM0a7pLXxY8DfFv2L2FtPgu7t7RUkAGggXWOVoOZoWP+org4E25zS9xIcJDXfGDnV/hYugjAede0AjKkZ/1h+WWD46oIBT3PuhM0cnKkSPb3eblPOLzCG8IgBTtHLOoFkmXBcPwdxXkV+JpUmdIH9rXvIswafaiPv5GcgBRJlMVxiTspD+UQdb39nD3Rx2YKkZk5fh5bylFgYs52Bb/SYnEfAHjv7VMyKaYBbKy6C+5NgnbPec2SYzH5E20nANHGiELArHMPDlSAZmsR66f7C9Mjdf8Epeh2GfaPEgMLiElRwFvGdtDHiHZlNhfyZMQA+EwzN8gvloCNiIbGKcH2XlAmC32tgqvZiAQzlN48Rg58jSYrCAkOCxEEK2EpQcZegGToCAIzC5BkAt740PloChSmSNz1ElYIyR0Ih69IbkTJpOLHOZ6W5xJyKEeLQUAibBx0wx9KQx85bKPPENa4Pvg19EilGCxPdf9aBEq3DHlOB2WpveBWXr4Ez6rAOaWHMU3jACP2ZprktkRGo4cNMlaIS5wst706MXDuGEI8kdOkRIKhiDnoxffAUbEdRS5OA4MJuLonKoLCTl0PB299B6Qdcs7euU9IPutVQFKeL1urYkCqiDJ0jdcLL/QX0Y9b0mucqiVXWf+2QChA9fA1Q1dHWoFblnIOGhTco35f4SGN6IgSzhfdqQuRkcbJciosfyCLqCJupi6jakYiILMMyjhVJZgN5YSEtwdDrEh5YksR65edZzGvQjmAogJ75z/kb4+t+6GclRykiC6rZl6wnc5mr4V4YecJB+igihnJ4mtLJvd56j8+zy5mjBikDIqiOgur1CWkqgrYoQZIFbixmxEW+U4Cot/NSJhA/EgCYZPWsnw08DxFYpNhgzP0AQZut9gbeEbVLaL3h6mYpbw7B4x/h0Qv5f1d/C8sMqHHiX7GmPZPSlBYoSHqFJlVSUlw39wBLmiCdKPtUSkjoqGWAPf5YLXNowoSD+Mx2zIs6WSCcHoSBfR3tzzmRfcFpdPyR/Q6JIg2kivMo3DWRagjVI10CV5or046T4Fv3Dv1rfeUdt0ECn5bvM4oqGNA9HiEUMUufMQbM3qAO08QewV4jsPIXyByEcpT6Je94PfJZG+PvRAaA5BPQDgVwVEpQBg1jsv1EIiHDWSNZESyVr1QqUaYS+5ybwQb11DQoj6Hvho3+hemruGAUNmsaGrxRLJ1cPgb8tTFOSe0weBjzEPW196psSor4Dq7IRbibvwzsusHv0oa/0vKhG+EPxnQZMFi95/1lIGxC7VTCI158oRGNFee8ltlwEND0f75sQwmjRbt7XVrWDej/QgCLRbUhEbnv853zNRCUPF6EmFkaHazUPGz9R8GZam6RGiFTJJADmsLO6Tf93MDrmECFB/E3bkz/i4XUaAMKyJifpl4P6wlG4RE5GdK1GHEMOOlp7LXO+e/eZyJrQrYqeZqXsPFctx1kFK32EMzuPVrGzxZMFMZLCXvOy+g+KJElyT7OaRWAlRne32tjVtvqahnc2zdpXW3inItUb8dPWR+dWALFDy1OGjLmgSVOC5sQ9eV22DF/IcM00fc+hgKBTbmnynzQqzQ14YmsCpSoj0LQZlnZLnhCCYJ1mlplDceSrTrecO875gQfA0qzGSdl/pImwJyd6fnQAsCO7dC6b0Tm2iW2SN2T4z/mBjx1aArCtIcdbfdhrIArlf/HyoPF2bw8gebz/ZBtCBiB99l2107QWO246TytoQRSIwTUTsCrIn2qCRxA3R23GCtIMHSWQRaddr7YmmqRKrw7+BSH0Jbk+8bfMoToxJk8i6Z1fREK+BZsZjg6ibNlcyBDowuWEuQKcfK1CqUJ5VBO32SpdapJ1Y4oAC4rJP/9/T1V9CLFQNXssNAgT6Vx8jcDjRSmaPSvsz2T410KCKjohIDA7ykjjXLQ5mYk7xt4E1QvTtpsdD/0IsDsKQmsVhLdxQ4lET8tDi0tnChjDIvivYdSWBFfQoUWXP5k+nE8Pbnpyqv0NLKPwva+ZbiDkEXc0VSLCAGrWJ02sJwSndxrShmkkSWktHzBfWnrt+VfnWdjgPWaJE8CXeEO0K3ehjL9fgruvW+Xy2dO2eiTCZIA273T61nkRx4qfeAmFAFbMwHFuhDIzDXaDKLMeFDhI6tw/uqjtuOqK2D5iR6FdUksG25b7u7Ljy9Ap/89y09O0yh0E+uJRQvuMBOxTen3Cz6a1rPHHvzyfZXc7QnHT0LPq0KbxJSci+K6uvyNLsXBhN+1af7GT7O/bdR4T6iDmbLb2YHwKoEbDXlrWvX6teJ1/vU22G9hmER7PebtjuqUEJVYAcqLyo5pvq03VIuicFe9U/6sRfll3HtPTcPVjn2ztyckRvU38atR/k+t9coKhGjW/IyZXVxiXRVLiTwhdGuKv1klFqGLT80ovnsD3ru0AhhYNcVgjaJOC3mQ0PA67OSM9o7HA4pXHkLLrTSacW2+epGTjIc5BDLrHl/LwR5lW26mCDy6Jxp+NZhTdeSoDwca9w8IDDbhOZSFGgbErqB/JpTW9LujthEXQEJL1GPrLb9OHvF4wpxSIo0BcQupZWx0ys5k6eZgUBJmLNmYkhjeZZCjVwvEIdhHqn0J6WFm443x4NSCkdjzMwIR8To5cQ7xAplidX7aK9wt8K35vkQZh0x+S/tPatJwWdN3hDHLwPx7+AbDTmelPOxW8V4OHa6kGEQUCokIbacN1Cp0Jn9rgQkJtbW0iNOqUcBgFBhxTbkHEh5LaYJaeegU+g202smkfxOAREnoZItWfP1gYIIDHH7HhW6+zBFvHGcPAgNbdKx2NR7DrLBbweZ8o0uPiKmNzV3hfIwWENOiwuR10+QJE+a4l9u0yx2BC4OLQA/Fzqkwy+JyZDWCbZl8jrWP4ywFfE0BoigyL2LfoFsSc21ke48F5fM0rbJpkY6eUhZfzwxQIQLq4MIGt1trC684BxSv6LRTvKgNMquwouZOqV9ueuKFq21toLyPHthlrDdvP8t/gQItGJpjfivdgL3ljs543syPgEvaEbEbkOZIL2IV13feBP61oHWsLrB5pEiN4/jISU7CDTFhqBWvcaRNghzgQ+OxtJgN4K/x0PnBsLvKwmzs3SgkxULqEkSeHFuGbaOXLlCafOc2TvEEEwELoKmdR1rKf4rT+Zzd5jKutuV4E1V4VbthpbwdIOfjEZ7Iu23bmVLq1Keu7tuXYMR388PCNh52XTMOazcN5/P9FGCCndRydb/jJs9L0DgnfPOFMEu+sOtmz+9rjyVzVHQKs33NHZnRsqHt7MuTncx88oxh3UR1AAMxrmtu0v6khSQvujvQPrAe8ILw0LXkRx7Wsu7xD7sRuYBYs2vnkDTin4dGcigtNnodiaDzeP6zpbkhIdpAVRAm9SjU3TcKE2SY/sMOC2wcBjdwi0szZOITS0pUabmGtbWwhAHqdcqhya7I9gtMdGvuvSDn3FehOVkp3E3uwBf9kn8ck9CidvIEhz0uZf6rpLg3RS2ztR1QprzidXLHanlPpebT3RH3isq7egrIc4Dmw17Ev5zX4JylHnBydh+yOkhZ/HEwx8tw8ftann6mrs+Du7t/LNI/O3EFH3U8UEfzFwCeigqN0kxASp3K3KbcVlTcFWKDYFtW8yqH5/Upb2b8LP33mxfxIycnAlXQJ+v2y7PH0KPgcaHmdnay5CXDzRNvBbJVDwAq+1SaS45S6A0m1G+Mdzl+EDXBeBoZjlgD47z3SEg37gPALJUIItR7ELYD+uh/1Q+xtUMBK88Z5a4bA840g5qj1BGstUQy/0Kg2P06sSwE5oGTl1Z+PiKW7+KbJD5fgBinVneMSZcmIZjYAbQ/dD/BWMXLEEe90EoArcuVg8A/Iz/YDzow9ZAZdU+PNamw/K7SjGhR1zObAPO6PYPIJ8rMp8xSo2BB0z+12ZncEpTyK03FbTxaIEVX9kYVyYl46I4sVSCiAg2+bsLwitOuNQQfS8043yhZBzTS9sd26YUaj7tV3zBXlh/gEzh8Hkq1JKvZenhhmFd/jezi/YjpDUD4IShH9p50Aw6et8F5RKz9iLmFmO78Hfvhw+9/xTalUDqAqnd4qzDM/z9shRV46HkbYfdYUIFXSDarNO6BQXx+d9qwFRBEB/QKKVJd/iDTDDhWoM6s+CN9nCN/2O92rTanlVV4oOj61mYZtFWC/lLqonzCPRysyYNf+kkQ/QFEg5UTs7r+TXTeK3HtTpffj+P8QAoH1t6ogPvhrQHwTj6gP6jn0Ob1n+F7DdtyZcWI7iQiWwPn2bIYt/92jNcjXPiiAAAAAASUVORK5CYII=";
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setMail(email);
        user.setMotdepasse(password);
        user.setNumtel(numtel);
        user.setImageuser(imageUser);
        user.setStatus("false");

        client.addUser(user).enqueue(new Callback<com.example.zanimo11.Models.user>() {
            @Override
            public void onResponse(Call<com.example.zanimo11.Models.user> call, Response<com.example.zanimo11.Models.user> response) {
                Toast.makeText(getApplicationContext(),"user added",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<com.example.zanimo11.Models.user> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

}